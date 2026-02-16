package com.mojang.minecraft.p002b;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/* JADX INFO: renamed from: com.mojang.minecraft.b.g */
/* JADX INFO: loaded from: c0.0.16a_02.jar:com/mojang/minecraft/b/g.class */
public class RunnableC0017g extends C0014d implements Runnable {

    /* JADX INFO: renamed from: f */
    private C0014d f94f;

    /* JADX INFO: renamed from: g */
    private boolean f95g = false;

    /* JADX INFO: renamed from: h */
    private boolean f96h = false;

    /* JADX INFO: renamed from: i */
    private String[] f97i = null;

    /* JADX INFO: renamed from: j */
    private String f98j = "";

    /* JADX INFO: renamed from: e */
    protected String f99e = "Load level";

    public RunnableC0017g(C0014d c0014d) {
        this.f94f = c0014d;
    }

    /* JADX WARN: Not initialized variable reg: 0, insn: 0x0087: INVOKE (r0 I:java.lang.Exception) VIRTUAL call: java.lang.Exception.printStackTrace():void A[MD:():void (c)], block:B:8:0x0086 */
    @Override // java.lang.Runnable
    public void run() {
        Exception excPrintStackTrace;
        try {
            this.f98j = "Getting level list..";
            this.f97i = new BufferedReader(new InputStreamReader(new URL("http://" + this.f81a.f148f + "/listmaps.jsp?user=" + this.f81a.f147e.f18a).openConnection().getInputStream())).readLine().split(";");
            if (this.f97i.length < 5) {
                this.f98j = this.f97i[0];
                this.f95g = true;
            } else {
                mo45a(this.f97i);
                this.f96h = true;
            }
        } catch (Exception e) {
            excPrintStackTrace.printStackTrace();
            this.f98j = "Failed to load levels";
            this.f95g = true;
        }
    }

    /* JADX INFO: renamed from: a */
    protected void mo45a(String[] strArr) {
        for (int i = 0; i < 5; i++) {
            ((C0015e) this.f84d.get(i)).f91g = !strArr[i].equals("-");
            ((C0015e) this.f84d.get(i)).f89e = strArr[i];
            ((C0015e) this.f84d.get(i)).f92h = true;
        }
    }

    @Override // com.mojang.minecraft.p002b.C0014d
    /* JADX INFO: renamed from: a */
    public final void mo33a() {
        new Thread(this).start();
        for (int i = 0; i < 5; i++) {
            this.f84d.add(new C0015e(i, (this.f82b / 2) - 100, (this.f83c / 4) + (i * 24), 200, 20, "---"));
            ((C0015e) this.f84d.get(i)).f92h = false;
        }
        this.f84d.add(new C0015e(5, (this.f82b / 2) - 100, (this.f83c / 4) + 144, 200, 20, "Cancel"));
    }

    @Override // com.mojang.minecraft.p002b.C0014d
    /* JADX INFO: renamed from: a */
    protected final void mo36a(C0015e c0015e) {
        if (c0015e.f91g) {
            if (this.f96h && c0015e.f90f < 5) {
                mo46a(c0015e.f90f);
            }
            if (this.f95g || (this.f96h && c0015e.f90f == 5)) {
                this.f81a.m57a(this.f94f);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    protected void mo46a(int i) {
        this.f81a.m77b(this.f81a.f147e.f18a, i);
        this.f81a.m57a((C0014d) null);
        this.f81a.m61c();
    }

    @Override // com.mojang.minecraft.p002b.C0014d
    /* JADX INFO: renamed from: a */
    public final void mo38a(int i, int i2) {
        m41a(0, 0, this.f82b, this.f83c, 1610941696, -1607454624);
        m42a(this.f99e, this.f82b / 2, 40, 16777215);
        if (!this.f96h) {
            m42a(this.f98j, this.f82b / 2, (this.f83c / 2) - 4, 16777215);
        }
        super.mo38a(i, i2);
    }
}
