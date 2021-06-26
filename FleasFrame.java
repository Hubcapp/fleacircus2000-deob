import java.awt.Event;
import java.awt.Frame;
import java.awt.Graphics;

// $FF: renamed from: b
public class FleasFrame extends Frame {
    // $FF: renamed from: a int
    int frameWidth;
    // $FF: renamed from: b int
    int frameHeight;
    // $FF: renamed from: c int
    int alwaysZero = 0;
    // $FF: renamed from: d int
    int heightAdjustment = 28;
    // $FF: renamed from: e a
    FleasApplet fleasApplet;
    // $FF: renamed from: f java.awt.Graphics
    Graphics fleasGraphics;

    public FleasFrame(FleasApplet fleasApplet, int width, int height, String windowTitle, boolean resizable, boolean changeHeight) {
        this.frameWidth = width;
        this.frameHeight = height;
        this.fleasApplet = fleasApplet;
        if (changeHeight) {
            this.heightAdjustment = 48;
        } else {
            this.heightAdjustment = 28;
        }

        this.setTitle(windowTitle);
        this.setResizable(resizable);
        this.show();
        this.toFront();
        this.resize(this.frameWidth, this.frameHeight);
        this.fleasGraphics = this.getGraphics();
    }

    public final void paint(Graphics g) {
        this.fleasApplet.paint(g);
    }

    // $FF: renamed from: a () int
    public int getWidth_() {
        return this.size().width;
    }

    public void resize(int width, int height) {
        super.resize(width, height + this.heightAdjustment);
    }

    // $FF: renamed from: b () int
    public int decrementHeight() {
        return this.size().height - this.heightAdjustment;
    }

    public Graphics getGraphics() {
        Graphics g = super.getGraphics();
        if (this.alwaysZero == 0) {
            g.translate(0, 24);
        } else {
            g.translate(-5, 0);
        }

        return g;
    }

    public boolean handleEvent(Event e) {
        if (e.id == 401) {
            this.fleasApplet.keyDown(e, e.key);
        } else if (e.id == 402) {
            this.fleasApplet.keyUp(e, e.key);
        } else if (e.id == 501) {
            this.fleasApplet.mouseDown(e, e.x, e.y - 24);
        } else if (e.id == 506) {
            this.fleasApplet.mouseDrag(e, e.x, e.y - 24);
        } else if (e.id == 502) {
            this.fleasApplet.mouseUp(e, e.x, e.y - 24);
        } else if (e.id == 503) {
            this.fleasApplet.mouseMove(e, e.x, e.y - 24);
        } else if (e.id == 201) {
            this.fleasApplet.destroy();
        } else if (e.id == 1001) {
            this.fleasApplet.action(e, e.target);
        } else if (e.id == 403) {
            this.fleasApplet.keyDown(e, e.key);
        } else if (e.id == 404) {
            this.fleasApplet.keyUp(e, e.key);
        }

        return true;
    }
}
