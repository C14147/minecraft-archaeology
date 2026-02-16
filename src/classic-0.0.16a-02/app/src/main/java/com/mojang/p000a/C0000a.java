package com.mojang.p000a;

import com.mojang.minecraft.level.C0029a;
import com.mojang.minecraft.level.Level;
import com.mojang.minecraft.net.C0046a;
import com.mojang.minecraft.net.C0048c;
import com.mojang.minecraft.net.NetworkPlayer;
import com.mojang.minecraft.p002b.C0018h;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: renamed from: com.mojang.a.a */
/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/a/a.class */
public final class C0000a {

    /* JADX INFO: renamed from: a */
    public volatile boolean f0a;

    /* JADX INFO: renamed from: e */
    public C0048c f4e;

    /* JADX INFO: renamed from: f */
    private Socket f5f;

    /* JADX INFO: renamed from: c */
    public ByteBuffer f2c = ByteBuffer.allocate(1048576);

    /* JADX INFO: renamed from: d */
    public ByteBuffer f3d = ByteBuffer.allocate(1048576);

    /* JADX INFO: renamed from: g */
    private boolean f6g = false;

    /* JADX INFO: renamed from: h */
    private byte[] f7h = new byte[64];

    /* JADX INFO: renamed from: b */
    public SocketChannel f1b = SocketChannel.open();

    public C0000a(String str, int i) throws IOException {
        this.f1b.connect(new InetSocketAddress(str, i));
        this.f1b.configureBlocking(false);
        System.currentTimeMillis();
        this.f5f = this.f1b.socket();
        this.f0a = true;
        this.f2c.clear();
        this.f3d.clear();
        this.f5f.setTcpNoDelay(true);
        this.f5f.setTrafficClass(24);
        this.f5f.setKeepAlive(false);
        this.f5f.setReuseAddress(false);
        this.f5f.setSoTimeout(100);
        this.f5f.getInetAddress().toString();
    }

    /* JADX INFO: renamed from: a */
    public final void m0a() {
        try {
            if (this.f3d.position() > 0) {
                this.f3d.flip();
                this.f1b.write(this.f3d);
                this.f3d.compact();
            }
        } catch (Exception unused) {
        }
        this.f0a = false;
        try {
            this.f1b.close();
        } catch (Exception unused2) {
        }
        this.f5f = null;
        this.f1b = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v49 */
    /* JADX WARN: Type inference failed for: r0v50, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r0v72, types: [java.io.ByteArrayOutputStream] */
    /* JADX INFO: renamed from: b */
    public final void m1b() {
        NetworkPlayer networkPlayer;
        NetworkPlayer networkPlayer2;
        NetworkPlayer networkPlayer3;
        NetworkPlayer networkPlayer4;
        NetworkPlayer networkPlayer5;
        this.f1b.read(this.f2c);
        int i = 0;
        while (true) {
            if (this.f2c.position() <= 0) {
                break;
            }
            int i2 = i;
            i++;
            if (i2 == 100) {
                break;
            }
            this.f2c.flip();
            byte b = this.f2c.get(0);
            C0046a c0046a = C0046a.f255a[b];
            if (c0046a == null) {
                throw new IOException("Bad command: " + ((int) b));
            }
            if (this.f2c.remaining() < c0046a.f270p + 1) {
                this.f2c.compact();
                break;
            }
            this.f2c.get();
            Object[] objArr = new Object[c0046a.f273r.length];
            for (int i3 = 0; i3 < objArr.length; i3++) {
                objArr[i3] = m3a(c0046a.f273r[i3]);
            }
            C0048c c0048c = this.f4e;
            if (c0046a == C0046a.f256b) {
                c0048c.f283c.m72a(objArr[1].toString());
                c0048c.f283c.m73b(objArr[2].toString());
            } else if (c0046a == C0046a.f257c) {
                c0048c.f283c.m78a((Level) null);
                c0048c.f281a = new ByteArrayOutputStream();
            } else if (c0046a == C0046a.f258d) {
                short sShortValue = ((Short) objArr[0]).shortValue();
                byte[] bArr = (byte[]) objArr[1];
                c0048c.f283c.m74a((int) ((Byte) objArr[2]).byteValue());
                c0048c.f281a.write(bArr, 0, sShortValue);
            } else {
                ?? r0 = c0046a;
                if (r0 == C0046a.f259e) {
                    try {
                        r0 = c0048c.f281a;
                        r0.close();
                    } catch (IOException e) {
                        r0.printStackTrace();
                    }
                    byte[] bArrM90c = C0029a.m90c(new ByteArrayInputStream(c0048c.f281a.toByteArray()));
                    c0048c.f281a = null;
                    short sShortValue2 = ((Short) objArr[0]).shortValue();
                    short sShortValue3 = ((Short) objArr[1]).shortValue();
                    short sShortValue4 = ((Short) objArr[2]).shortValue();
                    Level level = new Level();
                    level.setData(sShortValue2, sShortValue3, sShortValue4, bArrM90c);
                    c0048c.f283c.m78a(level);
                    c0048c.f283c.f186m = false;
                } else if (c0046a == C0046a.f261g) {
                    if (c0048c.f283c.f142c != null) {
                        c0048c.f283c.f142c.setTile(((Short) objArr[0]).shortValue(), ((Short) objArr[1]).shortValue(), ((Short) objArr[2]).shortValue(), ((Byte) objArr[3]).byteValue());
                    }
                } else if (c0046a == C0046a.f262h) {
                    byte bByteValue = ((Byte) objArr[0]).byteValue();
                    String str = (String) objArr[1];
                    short sShortValue5 = ((Short) objArr[2]).shortValue();
                    short sShortValue6 = ((Short) objArr[3]).shortValue();
                    short sShortValue7 = ((Short) objArr[4]).shortValue();
                    byte bByteValue2 = ((Byte) objArr[5]).byteValue();
                    byte bByteValue3 = ((Byte) objArr[6]).byteValue();
                    if (bByteValue >= 0) {
                        NetworkPlayer networkPlayer6 = new NetworkPlayer(c0048c.f283c, bByteValue, str, sShortValue5, sShortValue6, sShortValue7, ((-bByteValue2) * 360) / 256.0f, (bByteValue3 * 360) / 256.0f);
                        c0048c.f284d.put(Byte.valueOf(bByteValue), networkPlayer6);
                        c0048c.f283c.f142c.entities.add(networkPlayer6);
                    } else {
                        c0048c.f283c.f144d.moveTo(sShortValue5 / 32.0f, sShortValue6 / 32.0f, sShortValue7 / 32.0f, ((-bByteValue2) * 360) / 256.0f, (bByteValue3 * 360) / 256.0f);
                    }
                } else if (c0046a == C0046a.f263i) {
                    byte bByteValue4 = ((Byte) objArr[0]).byteValue();
                    short sShortValue8 = ((Short) objArr[1]).shortValue();
                    short sShortValue9 = ((Short) objArr[2]).shortValue();
                    short sShortValue10 = ((Short) objArr[3]).shortValue();
                    byte bByteValue5 = ((Byte) objArr[4]).byteValue();
                    byte bByteValue6 = ((Byte) objArr[5]).byteValue();
                    if (bByteValue4 >= 0 && (networkPlayer5 = (NetworkPlayer) c0048c.f284d.get(Byte.valueOf(bByteValue4))) != null) {
                        networkPlayer5.teleport(sShortValue8, sShortValue9, sShortValue10, ((-bByteValue5) * 360) / 256.0f, (bByteValue6 * 360) / 256.0f);
                    }
                } else if (c0046a == C0046a.f264j) {
                    byte bByteValue7 = ((Byte) objArr[0]).byteValue();
                    byte bByteValue8 = ((Byte) objArr[1]).byteValue();
                    byte bByteValue9 = ((Byte) objArr[2]).byteValue();
                    byte bByteValue10 = ((Byte) objArr[3]).byteValue();
                    byte bByteValue11 = ((Byte) objArr[4]).byteValue();
                    byte bByteValue12 = ((Byte) objArr[5]).byteValue();
                    if (bByteValue7 >= 0 && (networkPlayer4 = (NetworkPlayer) c0048c.f284d.get(Byte.valueOf(bByteValue7))) != null) {
                        networkPlayer4.queue(bByteValue8, bByteValue9, bByteValue10, ((-bByteValue11) * 360) / 256.0f, (bByteValue12 * 360) / 256.0f);
                    }
                } else if (c0046a == C0046a.f266l) {
                    byte bByteValue13 = ((Byte) objArr[0]).byteValue();
                    byte bByteValue14 = ((Byte) objArr[1]).byteValue();
                    byte bByteValue15 = ((Byte) objArr[2]).byteValue();
                    if (bByteValue13 >= 0 && (networkPlayer3 = (NetworkPlayer) c0048c.f284d.get(Byte.valueOf(bByteValue13))) != null) {
                        networkPlayer3.queue(((-bByteValue14) * 360) / 256.0f, (bByteValue15 * 360) / 256.0f);
                    }
                } else if (c0046a == C0046a.f265k) {
                    byte bByteValue16 = ((Byte) objArr[0]).byteValue();
                    byte bByteValue17 = ((Byte) objArr[1]).byteValue();
                    byte bByteValue18 = ((Byte) objArr[2]).byteValue();
                    byte bByteValue19 = ((Byte) objArr[3]).byteValue();
                    if (bByteValue16 >= 0 && (networkPlayer2 = (NetworkPlayer) c0048c.f284d.get(Byte.valueOf(bByteValue16))) != null) {
                        networkPlayer2.queue(bByteValue17, bByteValue18, bByteValue19);
                    }
                } else if (c0046a == C0046a.f267m) {
                    byte bByteValue20 = ((Byte) objArr[0]).byteValue();
                    if (bByteValue20 >= 0 && (networkPlayer = (NetworkPlayer) c0048c.f284d.remove(Byte.valueOf(bByteValue20))) != null) {
                        c0048c.f283c.f142c.entities.remove(networkPlayer);
                    }
                } else if (c0046a == C0046a.f268n) {
                    byte bByteValue21 = ((Byte) objArr[0]).byteValue();
                    String str2 = (String) objArr[1];
                    if (bByteValue21 < 0) {
                        c0048c.f283c.m79c("&e" + str2);
                    } else {
                        c0048c.f284d.get(Byte.valueOf(bByteValue21));
                        c0048c.f283c.m79c(str2);
                    }
                } else if (c0046a == C0046a.f269o) {
                    c0048c.f283c.m57a(new C0018h("Connection lost", (String) objArr[0]));
                }
            }
            if (!this.f0a) {
                break;
            } else {
                this.f2c.compact();
            }
        }
        if (this.f3d.position() > 0) {
            this.f3d.flip();
            this.f1b.write(this.f3d);
            this.f3d.compact();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m2a(C0046a c0046a, Object... objArr) {
        if (this.f0a) {
            this.f3d.put(c0046a.f272q);
            for (int i = 0; i < objArr.length; i++) {
                Class cls = c0046a.f273r[i];
                Object obj = objArr[i];
                if (this.f0a) {
                    try {
                        if (cls == Long.TYPE) {
                            this.f3d.putLong(((Long) obj).longValue());
                        } else if (cls == Integer.TYPE) {
                            this.f3d.putInt(((Number) obj).intValue());
                        } else if (cls == Short.TYPE) {
                            this.f3d.putShort(((Number) obj).shortValue());
                        } else if (cls == Byte.TYPE) {
                            this.f3d.put(((Number) obj).byteValue());
                        } else if (cls == Double.TYPE) {
                            this.f3d.putDouble(((Double) obj).doubleValue());
                        } else if (cls == Float.TYPE) {
                            this.f3d.putFloat(((Float) obj).floatValue());
                        } else if (cls == String.class) {
                            byte[] bytes = ((String) obj).getBytes(Charset.forName("UTF-8"));
                            Arrays.fill(this.f7h, (byte) 32);
                            for (int i2 = 0; i2 < 64 && i2 < bytes.length; i2++) {
                                this.f7h[i2] = bytes[i2];
                            }
                            for (int length = bytes.length; length < 64; length++) {
                                this.f7h[length] = 32;
                            }
                            this.f3d.put(this.f7h);
                        } else if (cls == byte[].class) {
                            byte[] bArr = (byte[]) obj;
                            byte[] bArrCopyOf = bArr;
                            if (bArr.length < 1024) {
                                bArrCopyOf = Arrays.copyOf(bArrCopyOf, 1024);
                            }
                            this.f3d.put(bArrCopyOf);
                        }
                    } catch (Exception unused) {
                        this.f4e.f282b.m0a();
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public Object m3a(Class cls) {
        if (!this.f0a) {
            return null;
        }
        try {
            if (cls == Long.TYPE) {
                return Long.valueOf(this.f2c.getLong());
            }
            if (cls == Integer.TYPE) {
                return Integer.valueOf(this.f2c.getInt());
            }
            if (cls == Short.TYPE) {
                return Short.valueOf(this.f2c.getShort());
            }
            if (cls == Byte.TYPE) {
                return Byte.valueOf(this.f2c.get());
            }
            if (cls == Double.TYPE) {
                return Double.valueOf(this.f2c.getDouble());
            }
            if (cls == Float.TYPE) {
                return Float.valueOf(this.f2c.getFloat());
            }
            if (cls == String.class) {
                this.f2c.get(this.f7h);
                return new String(this.f7h, Charset.forName("UTF-8")).trim();
            }
            if (cls != byte[].class) {
                return null;
            }
            byte[] bArr = new byte[1024];
            this.f2c.get(bArr);
            return bArr;
        } catch (Exception unused) {
            this.f4e.f282b.m0a();
            return null;
        }
    }
}
