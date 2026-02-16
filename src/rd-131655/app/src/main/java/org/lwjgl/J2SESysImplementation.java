package org.lwjgl;

import java.awt.Component;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/* JADX INFO: loaded from: minecraft-rd-131655.jar:org/lwjgl/J2SESysImplementation.class */
abstract class J2SESysImplementation extends DefaultSysImplementation {
    J2SESysImplementation() {
    }

    @Override // org.lwjgl.DefaultSysImplementation, org.lwjgl.SysImplementation
    public long getTime() {
        return System.currentTimeMillis();
    }

    @Override // org.lwjgl.DefaultSysImplementation, org.lwjgl.SysImplementation
    public void alert(String title, String message) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            LWJGLUtil.log("Caught exception while setting LAF: " + e);
        }
        JOptionPane.showMessageDialog((Component) null, message, title, 2);
    }

    @Override // org.lwjgl.DefaultSysImplementation, org.lwjgl.SysImplementation
    public String getClipboard() {
        try {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            Transferable transferable = clipboard.getContents((Object) null);
            if (transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                return (String) transferable.getTransferData(DataFlavor.stringFlavor);
            }
            return null;
        } catch (Exception e) {
            LWJGLUtil.log("Exception while getting clipboard: " + e);
            return null;
        }
    }
}
