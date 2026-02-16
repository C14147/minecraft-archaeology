package com.mojang.p000a;

import com.mojang.minecraft.p001a.C0003a;
import com.mojang.minecraft.server.C0028d;
import java.net.Socket;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/* JADX INFO: renamed from: com.mojang.a.b */
/* JADX INFO: loaded from: minecraft-server.jar:com/mojang/a/b.class */
public final class C0001b {

    /* JADX INFO: renamed from: a */
    public volatile boolean f3a;

    /* JADX INFO: renamed from: b */
    public SocketChannel f4b;

    /* JADX INFO: renamed from: e */
    public C0028d f7e;

    /* JADX INFO: renamed from: g */
    private Socket f8g;

    /* JADX INFO: renamed from: f */
    public String f10f;

    /* JADX INFO: renamed from: c */
    public ByteBuffer f5c = ByteBuffer.allocate(1048576);

    /* JADX INFO: renamed from: d */
    public ByteBuffer f6d = ByteBuffer.allocate(1048576);

    /* JADX INFO: renamed from: h */
    private boolean f9h = false;

    /* JADX INFO: renamed from: i */
    private byte[] f11i = new byte[64];

    public C0001b(SocketChannel socketChannel) throws SocketException {
        this.f4b = socketChannel;
        this.f4b.configureBlocking(false);
        System.currentTimeMillis();
        this.f8g = this.f4b.socket();
        this.f3a = true;
        this.f5c.clear();
        this.f6d.clear();
        this.f8g.setTcpNoDelay(true);
        this.f8g.setTrafficClass(24);
        this.f8g.setKeepAlive(false);
        this.f8g.setReuseAddress(false);
        this.f8g.setSoTimeout(100);
        this.f10f = this.f8g.getInetAddress().toString();
    }

    /* JADX INFO: renamed from: a */
    public final void m0a() {
        try {
            if (this.f6d.position() > 0) {
                this.f6d.flip();
                this.f4b.write(this.f6d);
                this.f6d.compact();
            }
        } catch (Exception unused) {
        }
        this.f3a = false;
        try {
            this.f4b.close();
        } catch (Exception unused2) {
        }
        this.f8g = null;
        this.f4b = null;
    }

    /* JADX INFO: renamed from: a */
    public final void m1a(C0003a c0003a, Object... objArr) {
        if (this.f3a) {
            this.f6d.put(c0003a.f41r);
            for (int i = 0; i < objArr.length; i++) {
                Class cls = c0003a.f42s[i];
                Object obj = objArr[i];
                if (this.f3a) {
                    try {
                        if (cls == Long.TYPE) {
                            this.f6d.putLong(((Long) obj).longValue());
                        } else if (cls == Integer.TYPE) {
                            this.f6d.putInt(((Number) obj).intValue());
                        } else if (cls == Short.TYPE) {
                            this.f6d.putShort(((Number) obj).shortValue());
                        } else if (cls == Byte.TYPE) {
                            this.f6d.put(((Number) obj).byteValue());
                        } else if (cls == Double.TYPE) {
                            this.f6d.putDouble(((Double) obj).doubleValue());
                        } else if (cls == Float.TYPE) {
                            this.f6d.putFloat(((Float) obj).floatValue());
                        } else if (cls == String.class) {
                            byte[] bytes = ((String) obj).getBytes("UTF-8");
                            Arrays.fill(this.f11i, (byte) 32);
                            for (int i2 = 0; i2 < 64 && i2 < bytes.length; i2++) {
                                this.f11i[i2] = bytes[i2];
                            }
                            for (int length = bytes.length; length < 64; length++) {
                                this.f11i[length] = 32;
                            }
                            this.f6d.put(this.f11i);
                        } else if (cls == byte[].class) {
                            byte[] bArr = (byte[]) obj;
                            byte[] bArrCopyOf = bArr;
                            if (bArr.length < 1024) {
                                bArrCopyOf = Arrays.copyOf(bArrCopyOf, 1024);
                            }
                            this.f6d.put(bArrCopyOf);
                        }
                    } catch (Exception e) {
                        this.f7e.m70a(e);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public Object m2a(Class cls) {
        if (!this.f3a) {
            return null;
        }
        try {
            if (cls == Long.TYPE) {
                return Long.valueOf(this.f5c.getLong());
            }
            if (cls == Integer.TYPE) {
                return Integer.valueOf(this.f5c.getInt());
            }
            if (cls == Short.TYPE) {
                return Short.valueOf(this.f5c.getShort());
            }
            if (cls == Byte.TYPE) {
                return Byte.valueOf(this.f5c.get());
            }
            if (cls == Double.TYPE) {
                return Double.valueOf(this.f5c.getDouble());
            }
            if (cls == Float.TYPE) {
                return Float.valueOf(this.f5c.getFloat());
            }
            if (cls == String.class) {
                this.f5c.get(this.f11i);
                return new String(this.f11i, "UTF-8").trim();
            }
            if (cls != byte[].class) {
                return null;
            }
            byte[] bArr = new byte[1024];
            this.f5c.get(bArr);
            return bArr;
        } catch (Exception e) {
            this.f7e.m70a(e);
            return null;
        }
    }
}
