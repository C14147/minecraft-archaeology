package org.lwjgl.util;

import com.sun.media.sound.WaveFileReader;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import org.lwjgl.LWJGLUtil;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/util/WaveData.class */
public class WaveData {
    public final ByteBuffer data;
    public final int format;
    public final int samplerate;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !WaveData.class.desiredAssertionStatus();
    }

    private WaveData(ByteBuffer data, int format, int samplerate) {
        this.data = data;
        this.format = format;
        this.samplerate = samplerate;
    }

    public void dispose() {
        this.data.clear();
    }

    public static WaveData create(URL path) {
        try {
            WaveFileReader wfr = new WaveFileReader();
            return create(wfr.getAudioInputStream(new BufferedInputStream(path.openStream())));
        } catch (Exception e) {
            LWJGLUtil.log("Unable to create from: " + path + ", " + e.getMessage());
            return null;
        }
    }

    public static WaveData create(String path) {
        return create(Thread.currentThread().getContextClassLoader().getResource(path));
    }

    public static WaveData create(InputStream is) {
        try {
            return create(AudioSystem.getAudioInputStream(is));
        } catch (Exception e) {
            LWJGLUtil.log("Unable to create from inputstream, " + e.getMessage());
            return null;
        }
    }

    public static WaveData create(byte[] buffer) {
        try {
            return create(AudioSystem.getAudioInputStream(new BufferedInputStream(new ByteArrayInputStream(buffer))));
        } catch (Exception e) {
            LWJGLUtil.log("Unable to create from byte array, " + e.getMessage());
            return null;
        }
    }

    public static WaveData create(ByteBuffer buffer) {
        byte[] bytes;
        try {
            if (buffer.hasArray()) {
                bytes = buffer.array();
            } else {
                bytes = new byte[buffer.capacity()];
                buffer.get(bytes);
            }
            return create(bytes);
        } catch (Exception e) {
            LWJGLUtil.log("Unable to create from ByteBuffer, " + e.getMessage());
            return null;
        }
    }

    public static WaveData create(AudioInputStream ais) {
        AudioFormat audioformat = ais.getFormat();
        int channels = 0;
        if (audioformat.getChannels() == 1) {
            if (audioformat.getSampleSizeInBits() == 8) {
                channels = 4352;
            } else if (audioformat.getSampleSizeInBits() == 16) {
                channels = 4353;
            } else if (!$assertionsDisabled) {
                throw new AssertionError("Illegal sample size");
            }
        } else if (audioformat.getChannels() == 2) {
            if (audioformat.getSampleSizeInBits() == 8) {
                channels = 4354;
            } else if (audioformat.getSampleSizeInBits() == 16) {
                channels = 4355;
            } else if (!$assertionsDisabled) {
                throw new AssertionError("Illegal sample size");
            }
        } else if (!$assertionsDisabled) {
            throw new AssertionError("Only mono or stereo is supported");
        }
        try {
            int available = ais.available();
            if (available <= 0) {
                int channels2 = ((ais.getFormat().getChannels() * ((int) ais.getFrameLength())) * ais.getFormat().getSampleSizeInBits()) / 8;
            }
            byte[] buf = new byte[ais.available()];
            int total = 0;
            while (true) {
                int read = ais.read(buf, total, buf.length - total);
                if (read == -1 || total >= buf.length) {
                    break;
                }
                total += read;
            }
            ByteBuffer buffer = convertAudioBytes(buf, audioformat.getSampleSizeInBits() == 16, audioformat.isBigEndian() ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
            WaveData wavedata = new WaveData(buffer, channels, (int) audioformat.getSampleRate());
            try {
                ais.close();
            } catch (IOException e) {
            }
            return wavedata;
        } catch (IOException e2) {
            return null;
        }
    }

    private static ByteBuffer convertAudioBytes(byte[] audio_bytes, boolean two_bytes_data, ByteOrder order) {
        ByteBuffer dest = ByteBuffer.allocateDirect(audio_bytes.length);
        dest.order(ByteOrder.nativeOrder());
        ByteBuffer src = ByteBuffer.wrap(audio_bytes);
        src.order(order);
        if (two_bytes_data) {
            ShortBuffer dest_short = dest.asShortBuffer();
            ShortBuffer src_short = src.asShortBuffer();
            while (src_short.hasRemaining()) {
                dest_short.put(src_short.get());
            }
        } else {
            while (src.hasRemaining()) {
                dest.put(src.get());
            }
        }
        dest.rewind();
        return dest;
    }
}
