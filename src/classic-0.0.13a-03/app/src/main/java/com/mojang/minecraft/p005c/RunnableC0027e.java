package com.mojang.minecraft.p005c;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/* JADX INFO: renamed from: com.mojang.minecraft.c.e */
/* JADX INFO: loaded from: Classic 0.0.13a 03.jar:com/mojang/minecraft/c/e.class */
public class RunnableC0027e extends C0026d implements Runnable {

    /* JADX INFO: renamed from: f */
    private C0026d f166f;

    /* JADX INFO: renamed from: g */
    private boolean f167g = false;

    /* JADX INFO: renamed from: h */
    private boolean f168h = false;

    /* JADX INFO: renamed from: i */
    private String[] f169i = null;

    /* JADX INFO: renamed from: j */
    private String f170j = "";

    /* JADX INFO: renamed from: e */
    protected String f171e = "Load level";

    public RunnableC0027e(C0026d c0026d) {
        this.f166f = c0026d;
    }

    /* JADX WARN: Not initialized variable reg: 0, insn: 0x0087: INVOKE (r0 I:java.lang.Exception) VIRTUAL call: java.lang.Exception.printStackTrace():void A[MD:():void (c)], block:B:8:0x0086 */
    @Override // java.lang.Runnable
    public void run() {
        Exception excPrintStackTrace;
        try {
            this.f170j = "Getting level list..";
            this.f169i = new BufferedReader(new InputStreamReader(new URL("http://" + this.f162a.f125e + "/listmaps.jsp?user=" + this.f162a.f124d.f174a).openConnection().getInputStream())).readLine().split(";");
            if (this.f169i.length < 5) {
                this.f170j = this.f169i[0];
                this.f167g = true;
            } else {
                mo96a(this.f169i);
                this.f168h = true;
            }
        } catch (Exception e) {
            excPrintStackTrace.printStackTrace();
            this.f170j = "Failed to load levels";
            this.f167g = true;
        }
    }

    /* JADX INFO: renamed from: a */
    protected void mo96a(String[] strArr) {
        for (int i = 0; i < 5; i++) {
            ((C0024b) this.f165d.get(i)).f160g = !strArr[i].equals("-");
            ((C0024b) this.f165d.get(i)).f158e = strArr[i];
            ((C0024b) this.f165d.get(i)).f161h = true;
        }
    }

    @Override // com.mojang.minecraft.p005c.C0026d
    /* JADX INFO: renamed from: a */
    public final void mo84a() {
        new Thread(this).start();
        for (int i = 0; i < 5; i++) {
            this.f165d.add(new C0024b(i, (this.f163b / 2) - 100, (this.f164c / 4) + (i * 24), 200, 20, "---"));
            ((C0024b) this.f165d.get(i)).f161h = false;
        }
        this.f165d.add(new C0024b(5, (this.f163b / 2) - 100, (this.f164c / 4) + 144, 200, 20, "Cancel"));
    }

    @Override // com.mojang.minecraft.p005c.C0026d
    /* JADX INFO: renamed from: a */
    protected final void mo87a(C0024b c0024b) {
        if (c0024b.f160g) {
            if (this.f168h && c0024b.f159f < 5) {
                mo97a(c0024b.f159f);
            }
            if (this.f167g || (this.f168h && c0024b.f159f == 5)) {
                this.f162a.m68a(this.f166f);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    protected void mo97a(int i) {
        this.f162a.m83a(this.f162a.f124d.f174a, i);
        this.f162a.m68a((C0026d) null);
        this.f162a.m72b();
    }

    @Override // com.mojang.minecraft.p005c.C0026d
    /* JADX INFO: renamed from: a */
    public final void mo89a(int i, int i2) {
        m92a(0, 0, this.f163b, this.f164c, 1610941696, -1607454624);
        m93a(this.f171e, this.f163b / 2, 40, 16777215);
        if (!this.f168h) {
            m93a(this.f170j, this.f163b / 2, (this.f164c / 2) - 4, 16777215);
        }
        super.mo89a(i, i2);
    }
}
