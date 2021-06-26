import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.IndexColorModel;
import java.awt.image.MemoryImageSource;
import java.io.IOException;

// $FF: renamed from: a
public class FleasApplet extends Applet implements Runnable {
    // $FF: renamed from: a int
    private int loadingStage = 1;
    // $FF: renamed from: b int
    private int frameWidth = 512;
    // $FF: renamed from: c int
    private int frameHeight = 384;
    // $FF: renamed from: d java.lang.Thread
    private Thread fleasThread = null;
    // $FF: renamed from: e int
    private int gameSpeed = 20;
    // $FF: renamed from: f int
    private int oneThousand = 1000;
    // $FF: renamed from: g long[]
    private long[] systemTimeProfiler = new long[10];
    // $FF: renamed from: h b
    private FleasFrame fleasComponent = null;
    // $FF: renamed from: i boolean
    private boolean isAppletMode;
    // $FF: renamed from: j int
    private int stopTimer = 0;
    // $FF: renamed from: k int
    private int lagIndicator = 0;
    // $FF: renamed from: l int
    public int mouseYOffset = 0;
    // $FF: renamed from: m boolean
    private boolean whiteLabeledGameRehosted = false;
    // $FF: renamed from: n int
    private int percentDone = 0;
    // $FF: renamed from: o java.awt.Font
    private Font timesRoman15 = new Font("TimesRoman", Font.PLAIN, 15);
    // $FF: renamed from: p java.awt.Font
    private Font helvetica13b = new Font("Helvetica", Font.BOLD, 13);
    // $FF: renamed from: q java.awt.Font
    private Font helvetica12 = new Font("Helvetica", Font.PLAIN, 12);
    // $FF: renamed from: r java.awt.Image
    private Image jagLogoTga;
    // $FF: renamed from: s java.awt.Graphics
    private Graphics loadingGraphics;
    // $FF: renamed from: t boolean
    public boolean leftCurlyBraceKeyIsDown = false;
    // $FF: renamed from: u boolean
    public boolean rightCurlyBraceKeyIsDown = false;
    // $FF: renamed from: v boolean
    public boolean leftArrowIsDown = false;
    // $FF: renamed from: w boolean
    public boolean rightArrowIsDown = false;
    // $FF: renamed from: x boolean
    public boolean upArrowIsDown = false;
    // $FF: renamed from: y boolean
    public boolean downArrowIsDown = false;
    // $FF: renamed from: z boolean
    public boolean spaceBarIsDown = false;
    // $FF: renamed from: A boolean
    public boolean nOrMKeyISDown = false;
    // $FF: renamed from: B int
    public int minimumTimeBetweenFrames = 1;
    // $FF: renamed from: C int
    public int mouseDownX = 0;
    // $FF: renamed from: D int
    public int mouseDownY = 0;
    // $FF: renamed from: E int
    public int mouseHeld = 0;
    // $FF: renamed from: F int
    public int mouseLastHeld = 0;
    // $FF: renamed from: G int
    public int keyHeldDown = 0;
    // $FF: renamed from: H int
    public int lastKeyHeldDown = 0;
    // $FF: renamed from: I boolean
    public boolean f1Toggle = false;
    // $FF: renamed from: J java.lang.String
    public String passwordDisplay = "";
    // $FF: renamed from: K java.lang.String
    public String passwordEntered = "";
    // $FF: renamed from: L java.lang.String
    public String textInputDisplay = "";
    // $FF: renamed from: M java.lang.String
    public String textInputEntered = "";
    // $FF: renamed from: N int
    public int appletSpeed = 0;

    public final void stop() {
        if (this.stopTimer >= 0) {
            this.stopTimer = 4000 / this.gameSpeed;
        }

    }

    public final Image createImage(int width, int height) {
        return this.fleasComponent == null ? super.createImage(width, height) : this.fleasComponent.createImage(width, height);
    }

    // $FF: renamed from: a () void
    public void nothing() {
    }

    // $FF: renamed from: a (int, int) void
    public void setGameSize(int width, int height) {
        this.handleResize(width, height);
    }

    // $FF: renamed from: b () void
    public void loadAssets() {
    }

    public final void update(Graphics graphics) {
        this.paint(graphics);
    }

    // $FF: renamed from: a (int) void
    public void updateLoadingBar(int percentDone) {
        int x = (this.frameWidth - 281) / 2;
        int y = (this.frameHeight - 148) / 2;
        this.loadingGraphics.setColor(Color.black);
        this.loadingGraphics.fillRect(0, 0, this.frameWidth, this.frameHeight);
        if (!this.whiteLabeledGameRehosted) {
            this.loadingGraphics.drawImage(this.jagLogoTga, x, y, this);
        }

        x += 2;
        y += 90;
        this.percentDone = percentDone;
        this.loadingGraphics.setColor(new Color(132, 132, 132));
        if (this.whiteLabeledGameRehosted) {
            this.loadingGraphics.setColor(new Color(220, 0, 0));
        }

        this.loadingGraphics.drawRect(x - 2, y - 2, 280, 23);
        this.loadingGraphics.fillRect(x, y, 277 * percentDone / 100, 20);
        this.loadingGraphics.setColor(new Color(198, 198, 198));
        if (this.whiteLabeledGameRehosted) {
            this.loadingGraphics.setColor(new Color(255, 255, 255));
        }

        this.drawCenteredText(this.loadingGraphics, "Now Loading - " + percentDone + "%", this.timesRoman15, x + 138, y + 10);
        if (!this.whiteLabeledGameRehosted) {
            this.drawCenteredText(this.loadingGraphics, "Created by JAGeX - visit www.jagex.com", this.helvetica13b, x + 138, y + 30);
            this.drawCenteredText(this.loadingGraphics, "Copyright ©2000 Andrew Gower", this.helvetica13b, x + 138, y + 44);
        } else {
            this.loadingGraphics.setColor(new Color(132, 132, 152));
            this.drawCenteredText(this.loadingGraphics, "Copyright ©2000 Andrew Gower", this.helvetica12, x + 138, this.frameHeight - 20);
        }

    }

    public final void start() {
        if (this.stopTimer >= 0) {
            this.stopTimer = 0;
            if (!this.fleasThread.isAlive() || this.fleasThread == null) {
                this.fleasThread = new Thread(this);
                this.fleasThread.start();
                System.out.println("Ressurect!");
            }
        }

    }

    // $FF: renamed from: a (int, int, java.lang.String, boolean) void
	// Called as myFleas.launchAsApplication(644, 390, "Flea circus - By Andrew Gower", false);
    public final void launchAsApplication(int width, int height, String windowTitle, boolean resizable) {
        this.isAppletMode = false;
        System.out.println("Started application");
        this.frameWidth = width;
        this.frameHeight = height;
        this.fleasComponent = new FleasFrame(this, width, height, windowTitle, resizable, false);
        this.loadingStage = 1;
        JagLoader.setApplet(this.fleasComponent, false);
        this.fleasThread = new Thread(this);
        this.fleasThread.start();
        this.fleasThread.setPriority(1);
    }

    // $FF: renamed from: c () void
    public synchronized void nothing_() {
    }

    public synchronized boolean keyDown(Event event, int key) {
        this.doNothingWithKey(key);
        this.keyHeldDown = key;
        this.lastKeyHeldDown = key;
        if (key == 1006) {
            this.leftArrowIsDown = true;
        }

        if (key == 1007) {
            this.rightArrowIsDown = true;
        }

        if (key == 1004) {
            this.upArrowIsDown = true;
        }

        if (key == 1005) {
            this.downArrowIsDown = true;
        }

        if ((char)key == ' ') {
            this.spaceBarIsDown = true;
        }

        if ((char)key == 'n' || (char)key == 'm') {
            this.nOrMKeyISDown = true;
        }

        if ((char)key == 'N' || (char)key == 'M') {
            this.nOrMKeyISDown = true;
        }

        if ((char)key == '{') {
            this.leftCurlyBraceKeyIsDown = true;
        }

        if ((char)key == '}') {
            this.rightCurlyBraceKeyIsDown = true;
        }

        if ((char)key == 1008) { // F1, used in RSC for interlaced video, not used here
            this.f1Toggle = !this.f1Toggle;
        }

        String tmp;
        if ((key >= 97 && key <= 122 || key >= 65 && key <= 90 || key >= 48 && key <= 57 || key == 32) && this.passwordDisplay.length() < 16) {
            tmp = this.passwordDisplay;
            this.passwordDisplay = tmp + (char)key;
        }

        if (key >= 32 && key <= 122 && this.textInputDisplay.length() < 80) {
            tmp = this.textInputDisplay;
            this.textInputDisplay = tmp + (char)key;
        }

        if (key == 8 && this.passwordDisplay.length() > 0) {
            this.passwordDisplay = this.passwordDisplay.substring(0, this.passwordDisplay.length() - 1);
        }

        if (key == 8 && this.textInputDisplay.length() > 0) {
            this.textInputDisplay = this.textInputDisplay.substring(0, this.textInputDisplay.length() - 1);
        }

        if (key == 10 || key == 13) {
            this.passwordEntered = this.passwordDisplay;
            this.textInputEntered = this.textInputDisplay;
        }

        return true;
    }

    // $FF: renamed from: b (int) void
    public void doNothingWithKey(int key) {
    }

    // $FF: renamed from: d () void
    public void destroyNothing() {
    }

    public final void paint(Graphics g) {
        if (this.loadingStage == 2) {
            this.updateLoadingBar(this.percentDone);
        } else if (this.loadingStage == 0) {
            this.nothing();
        }

    }

    public synchronized boolean mouseUp(Event event, int mouseX, int mouseY) {
        this.mouseDownX = mouseX;
        this.mouseDownY = mouseY + this.mouseYOffset;
        this.mouseHeld = 0;
        return true;
    }

    public FleasApplet() {
    }

    public final void destroy() {
        System.out.println("Closing program");
        this.stopTimer = -1;
        this.destroyNothing();
        if (this.fleasThread != null) {
            this.fleasThread.stop();
            this.fleasThread = null;
        }

        if (this.fleasComponent != null) {
            this.fleasComponent.dispose();
        }

        if (!this.isAppletMode) {
            System.exit(0);
        }

    }

    // $FF: renamed from: e () void
    public synchronized void processGameLogic() {
    }

    public synchronized boolean keyUp(Event event, int key) {
        this.keyHeldDown = 0;
        if (key == 1006) {
            this.leftArrowIsDown = false;
        }

        if (key == 1007) {
            this.rightArrowIsDown = false;
        }

        if (key == 1004) {
            this.upArrowIsDown = false;
        }

        if (key == 1005) {
            this.downArrowIsDown = false;
        }

        if ((char)key == ' ') {
            this.spaceBarIsDown = false;
        }

        if ((char)key == 'n' || (char)key == 'm') {
            this.nOrMKeyISDown = false;
        }

        if ((char)key == 'N' || (char)key == 'M') {
            this.nOrMKeyISDown = false;
        }

        if ((char)key == '{') {
            this.leftCurlyBraceKeyIsDown = false;
        }

        if ((char)key == '}') {
            this.rightCurlyBraceKeyIsDown = false;
        }

        return true;
    }

    public final Graphics getGraphics() {
        return this.fleasComponent == null ? super.getGraphics() : this.fleasComponent.getGraphics();
    }

    // $FF: renamed from: f () void
    public void loadJagexImages() {
        try {
            byte[] jagexDat = JagLoader.readFully("jagex/jagex.dat");
            byte[] jagLogo = JagLoader.extractBzippedFile("logo.tga", 0, jagexDat);
            this.jagLogoTga = this.loadTga(jagLogo);
        } catch (IOException ex) {
            System.out.println("Error loading jagex.dat");
        }
    }

    public synchronized boolean mouseDown(Event event, int mouseX, int mouseY) {
        this.mouseDownX = mouseX;
        this.mouseDownY = mouseY + this.mouseYOffset;
        if (event.metaDown()) {
            this.mouseHeld = 2;
        } else {
            this.mouseHeld = 1;
        }

        this.mouseLastHeld = this.mouseHeld;
        return true;
    }

    // $FF: renamed from: a (byte[]) java.awt.Image
    public Image loadTga(byte[] tgaData) {
        int width = tgaData[13] * 256 + tgaData[12];
        int height = tgaData[15] * 256 + tgaData[14];
        byte[] r = new byte[256];
        byte[] g = new byte[256];
        byte[] b = new byte[256];

        for(int i = 0; i < 256; ++i) {
            r[i] = tgaData[20 + i * 3];
            g[i] = tgaData[19 + i * 3];
            b[i] = tgaData[18 + i * 3];
        }

        IndexColorModel cm = new IndexColorModel(8, 256, r, g, b);
        byte[] pix = new byte[width * height];
        int i = 0;

        for(int x = height - 1; x >= 0; --x) {
            for(int y = 0; y < width; ++y) {
                pix[i++] = tgaData[786 + y + x * width];
            }
        }

        MemoryImageSource imageSource = new MemoryImageSource(width, height, cm, pix, 0, width);
        Image image = this.createImage(imageSource);
        return image;
    }

    // $FF: renamed from: b (int, int) void
    public final void handleResize(int newWidth, int newHeight) {
        if (this.fleasComponent != null) {
            this.fleasComponent.resize(newWidth, newHeight);
            this.frameWidth = newWidth;
            this.frameHeight = newHeight;
        }
    }

    public final void run() {
        if (this.loadingStage == 1) {
            this.loadingStage = 2;
            this.loadingGraphics = this.getGraphics();
            this.loadJagexImages();
            this.updateLoadingBar(0);
            this.loadAssets();
            this.loadingStage = 0;
        }

        int tpIdx = 0;
        int logicDelta = 256;
        int timeBetweenFrames = 1;
        int logicsDone = 0;

        int defaultLogicDelta;
        for(defaultLogicDelta = 0; defaultLogicDelta < 10; ++defaultLogicDelta) {
            this.systemTimeProfiler[defaultLogicDelta] = System.currentTimeMillis();
        }

        long startTime = System.currentTimeMillis();

        while(this.stopTimer >= 0) {
            if (this.stopTimer > 0) {
                this.stopTimer -= 1;
                if (this.stopTimer == 0) {
                    this.destroy();
                }

                return;
            }

            defaultLogicDelta = logicDelta;
            int defaultTimeBetweenFrames = timeBetweenFrames;
            logicDelta = 300;
            timeBetweenFrames = 1;
            startTime = System.currentTimeMillis();
            if (this.systemTimeProfiler[tpIdx] == 0L) {
                logicDelta = defaultLogicDelta;
                timeBetweenFrames = defaultTimeBetweenFrames;
            } else if (startTime > this.systemTimeProfiler[tpIdx]) { // sanity check that currentTimeMillis works
                logicDelta = (int)((long)(2560 * this.gameSpeed) / (startTime - this.systemTimeProfiler[tpIdx]));
            }

            if (logicDelta < 25) {
                logicDelta = 25;
            }

            if (logicDelta > 256) {
                logicDelta = 256;
                timeBetweenFrames = (int)((long)this.gameSpeed - (startTime - this.systemTimeProfiler[tpIdx]) / 10L);
                if (timeBetweenFrames < this.minimumTimeBetweenFrames) {
                    timeBetweenFrames = this.minimumTimeBetweenFrames;
                }
            }

            try {
                Thread.sleep((long)timeBetweenFrames);
            } catch (InterruptedException ex) {
                ;
            }

            this.systemTimeProfiler[tpIdx] = startTime;
            tpIdx = (tpIdx + 1) % 10;
            int i;
            if (timeBetweenFrames > 1) {
                for(i = 0; i < 10; ++i) {
                    if (this.systemTimeProfiler[i] != 0L) {
                        this.systemTimeProfiler[i] += (long)timeBetweenFrames;
                    }
                }
            }

            i = 0;

            while(logicsDone < 256) {
                this.processGameLogic();
                logicsDone += logicDelta;
                ++i;
                if (i > this.oneThousand) {
                    logicsDone = 0;
                    this.lagIndicator += 6;
                    if (this.lagIndicator > 25) {
                        this.lagIndicator = 0;
                        this.f1Toggle = true;
                    }
                    break;
                }
            }

            this.lagIndicator -= 1;
            logicsDone &= 255;
            this.nothing_();
            this.appletSpeed = 1000 * logicDelta / (this.gameSpeed * 256);
            if (this.isAppletMode && tpIdx == 0) {
                ;
            }

            if (this.fleasComponent != null && (this.fleasComponent.getWidth_() != this.frameWidth || this.fleasComponent.decrementHeight() != this.frameHeight)) {
                this.setGameSize(this.fleasComponent.getWidth_(), this.fleasComponent.decrementHeight());
            }
        }

    }

    // $FF: renamed from: c (int) void
    public final void setGameSpeed(int slowness) {
        this.gameSpeed = 1000 / slowness;
    }

    public final void init() {
        this.isAppletMode = true;
        System.out.println("Started applet");
        this.frameWidth = this.size().width;
        this.frameHeight = this.size().height;
        this.loadingStage = 1;
        JagLoader.setApplet(this, true);
        this.fleasThread = new Thread(this);
        this.fleasThread.start();
    }

    public synchronized boolean mouseDrag(Event event, int mouseX, int mouseY) {
        this.mouseDownX = mouseX;
        this.mouseDownY = mouseY + this.mouseYOffset;
        if (event.metaDown()) {
            this.mouseHeld = 2;
        } else {
            this.mouseHeld = 1;
        }

        return true;
    }

    // $FF: renamed from: a (java.awt.Graphics, java.lang.String, java.awt.Font, int, int) void
    public void drawCenteredText(Graphics g, String text, Font font, int x, int y) {
        FontMetrics fontMetrics = JagLoader.fleasComponent.getFontMetrics(font);
        fontMetrics.stringWidth(text);
        g.setFont(font);
        g.drawString(text, x - fontMetrics.stringWidth(text) / 2, y + fontMetrics.getHeight() / 4);
    }

    public synchronized boolean mouseMove(Event event, int mouseX, int mouseY) {
        this.mouseDownX = mouseX;
        this.mouseDownY = mouseY + this.mouseYOffset;
        this.mouseHeld = 0;
        return true;
    }
}
