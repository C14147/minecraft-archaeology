package com.mojang.minecraft.p001b;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/* JADX INFO: renamed from: com.mojang.minecraft.b.f */
/* JADX INFO: loaded from: Classic 0.0.14a 08.jar:com/mojang/minecraft/b/f.class */
public class RunnableC0015f extends C0012c implements Runnable {

    /* JADX INFO: renamed from: f */
    private C0012c f88f;

    /* JADX INFO: renamed from: g */
    private boolean f89g = false;

    /* JADX INFO: renamed from: h */
    private boolean f90h = false;

    /* JADX INFO: renamed from: i */
    private String[] f91i = null;

    /* JADX INFO: renamed from: j */
    private String f92j = "";

    /* JADX INFO: renamed from: e */
    protected String f93e = "Load level";

    public RunnableC0015f(C0012c c0012c) {
        this.f88f = c0012c;
    }

    /* JADX WARN: Not initialized variable reg: 0, insn: 0x0087: INVOKE (r0 I:java.lang.Exception) VIRTUAL call: java.lang.Exception.printStackTrace():void A[MD:():void (c)], block:B:8:0x0086 */
    @Override // java.lang.Runnable
    public void run() {
        Exception excPrintStackTrace;
        try {
            this.f92j = "Getting level list..";
            this.f91i = new BufferedReader(new InputStreamReader(new URL("http://" + this.f75a.f108d + "/listmaps.jsp?user=" + this.f75a.f107c.f10a).openConnection().getInputStream())).readLine().split(";");
            if (this.f91i.length < 5) {
                this.f92j = this.f91i[0];
                this.f89g = true;
            } else {
                mo41a(this.f91i);
                this.f90h = true;
            }
        } catch (Exception e) {
            excPrintStackTrace.printStackTrace();
            this.f92j = "Failed to load levels";
            this.f89g = true;
        }
    }

    /* JADX INFO: renamed from: a */
    protected void mo41a(String[] strArr) {
        for (int i = 0; i < 5; i++) {
            ((C0013d) this.f78d.get(i)).f85g = !strArr[i].equals("-");
            ((C0013d) this.f78d.get(i)).f83e = strArr[i];
            ((C0013d) this.f78d.get(i)).f86h = true;
        }
    }

    @Override // com.mojang.minecraft.p001b.C0012c
    /* JADX INFO: renamed from: a */
    public final void mo29a() {
        new Thread(this).start();
        for (int i = 0; i < 5; i++) {
            this.f78d.add(new C0013d(i, (this.f76b / 2) - 100, (this.f77c / 4) + (i * 24), 200, 20, "---"));
            ((C0013d) this.f78d.get(i)).f86h = false;
        }
        this.f78d.add(new C0013d(5, (this.f76b / 2) - 100, (this.f77c / 4) + 144, 200, 20, "Cancel"));
    }

    @Override // com.mojang.minecraft.p001b.C0012c
    /* JADX INFO: renamed from: a */
    protected final void mo32a(C0013d c0013d) {
        if (c0013d.f85g) {
            if (this.f90h && c0013d.f84f < 5) {
                mo42a(c0013d.f84f);
            }
            if (this.f89g || (this.f90h && c0013d.f84f == 5)) {
                this.f75a.m46a(this.f88f);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    protected void mo42a(int i) {
        this.f75a.m63a(this.f75a.f107c.f10a, i);
        this.f75a.m46a((C0012c) null);
        this.f75a.m50c();
    }

    @Override // com.mojang.minecraft.p001b.C0012c
    /* JADX INFO: renamed from: a */
    public final void mo34a(int i, int i2) {
        m37a(0, 0, this.f76b, this.f77c, 1610941696, -1607454624);
        m38a(this.f93e, this.f76b / 2, 40, 16777215);
        if (!this.f90h) {
            m38a(this.f92j, this.f76b / 2, (this.f77c / 2) - 4, 16777215);
        }
        super.mo34a(i, i2);
    }
}
