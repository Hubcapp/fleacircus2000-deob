import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;

public class fleas extends FleasApplet {
    // $FF: renamed from: O c
    XMPlayer xmPlayer;
    // $FF: renamed from: P int
    int isPlayingSound = 0;
    // $FF: renamed from: Q int
    int unusedInt180 = 180;
    // $FF: renamed from: R java.awt.Image[]
    Image[] blockPictures;
    // $FF: renamed from: S java.awt.Image
    Image uiImage;
    // $FF: renamed from: T java.awt.Image[]
    Image[] fleaPictures = new Image[4];
    // $FF: renamed from: U java.awt.Image
    Image gameImage;
    // $FF: renamed from: V java.awt.Image
    Image titlePicture;
    // $FF: renamed from: W int
    int titleScreenState = 1;
    // $FF: renamed from: X int
    int lastTitleScreenState = -1;
    // $FF: renamed from: Y int
    int pauseState = 0;
    // $FF: renamed from: Z java.awt.Graphics
    Graphics uiGraphics;
    // $FF: renamed from: ab java.awt.Graphics
    Graphics gameGraphics;
    // $FF: renamed from: bb java.awt.Font
    Font helvetica13;
    // $FF: renamed from: cb java.awt.Font
    Font helvetica13_;
    // $FF: renamed from: db java.awt.Font
    Font helvetica90;
    // $FF: renamed from: eb java.awt.Font
    Font helvetica36;
    // $FF: renamed from: fb java.awt.Font
    Font helvetica50;
    // $FF: renamed from: gb java.awt.Font
    Font helvetica20b;
    // $FF: renamed from: hb int
    int unusedInt28 = 28;
    // $FF: renamed from: ib int[]
    int[] fleaX = new int[40]; // pixel, not block
    // $FF: renamed from: jb int[]
    int[] fleaY = new int[40]; // pixel, not block
    // $FF: renamed from: kb int[]
    int[] fleaHorizontalSpeed = new int[40]; // 4 going right, -4 going left
    // $FF: renamed from: lb int[]
    int[] fleaInactive = new int[40]; // 1 if the flea has reached the goal or died
    // $FF: renamed from: mb int[]
    int[] fleaGoingUpType = new int[40]; // 2 when going up on spring, 1 when going up on balloon, 0 normally following gravity
    // $FF: renamed from: nb int[]
    int[] fleaWalkAnimation = new int[40];
    // $FF: renamed from: ob int
    int mouseClickX;
    // $FF: renamed from: pb int
    int mouseClickY;
    // $FF: renamed from: qb int
    int clickType = 0;
    // $FF: renamed from: rb int
    int mouseIsHeldDown = 0;
    // $FF: renamed from: sb int
    int fleaStartX;
    // $FF: renamed from: tb int
    int fleaStartY;
    // $FF: renamed from: ub int
    int fleasReleased = 40;
    // $FF: renamed from: vb int
    int countdownToFleaRelease;
    // $FF: renamed from: wb int
    int fleasToRelease = 40;
    // $FF: renamed from: xb int
    int fleasRescued = 0;
    // $FF: renamed from: yb int
    int selectedTool = 1;
    // $FF: renamed from: zb int
    int gamePadding = 32;
    // $FF: renamed from: Ab char[][]
    char[][] curLevelBlocks = new char[40][21];
    // $FF: renamed from: Bb int[][]
    int[][] walkBlockCollisionType = new int[160][100];
    // $FF: renamed from: Cb int
    int numberOfChangingBlocks = 0;
    // $FF: renamed from: Db int[]
    int[] changingBlockX = new int[50];
    // $FF: renamed from: Eb int[]
    int[] changingBlockY = new int[50];
    // $FF: renamed from: Fb int[]
    int[] isSpinningPlatform = new int[50];
    // $FF: renamed from: Gb int[]
    int[] changingBlockIdBefore = new int[50];
    // $FF: renamed from: Hb int[]
    int[] changingBlockIdAfter = new int[50];
    // $FF: renamed from: Ib int
    int animationFrame = 0;
    // $FF: renamed from: Jb int
    int numberOfSpiders;
    // $FF: renamed from: Kb int[]
    int[] spiderX = new int[10];
    // $FF: renamed from: Lb int[]
    int[] spiderY = new int[10];
    // $FF: renamed from: Mb int[]
    int[] spiderVerticalProgress = new int[10];
    // $FF: renamed from: Nb int[]
    int[] spiderSpeed = new int[10];
    // $FF: renamed from: Ob int
    int numberOfFans;
    // $FF: renamed from: Pb int[]
    int[] fanX = new int[5];
    // $FF: renamed from: Qb int[]
    int[] fanY = new int[4];
    // $FF: renamed from: Rb int[]
    int[] fanExploded = new int[4];
    // $FF: renamed from: Sb int[]
    int[] fanXPixelLeft = new int[5];
    // $FF: renamed from: Tb int[]
    int[] fanYPixelTop = new int[5];
    // $FF: renamed from: Ub int[]
    int[] fanXPixelRight = new int[5];
    // $FF: renamed from: Vb int[]
    int[] fanYPixelBottom = new int[5];
    // $FF: renamed from: Wb int
    int teleporterBlock1XCoord;
    // $FF: renamed from: Xb int
    int teleporterBlock1YCoord;
    // $FF: renamed from: Yb int
    int teleporterBlock2XCoord;
    // $FF: renamed from: Zb int
    int teleporterBlock2YCoord;
    // $FF: renamed from: ac int
    int numberOfTeleporterBlocks = 0;
    // $FF: renamed from: bc int
    int gravityDirectionPixel1 = 1;
    // $FF: renamed from: cc int
    int gravityDirectionWalk4 = 4;
    // $FF: renamed from: dc int
    int gravityDirectionBlock16 = 16;
    // $FF: renamed from: ec int
    int spiderIsAffectedByAntiGravity = 0;
    // $FF: renamed from: fc int
    int antiGravityYOffset = 0;
    // $FF: renamed from: gc int
    int levelIndex;
    // $FF: renamed from: hc int
    int antiGravityBlockCooldown = 0;
    // $FF: renamed from: ic int
    int blocksToAnimate = 0;
    // $FF: renamed from: jc int[]
    int[] animateBlockX = new int[1000];
    // $FF: renamed from: kc int[]
    int[] animateBlockY = new int[1000];
    // $FF: renamed from: lc java.awt.Image[]
    Image[] animatedBlockAnimation1 = new Image[50];
    // $FF: renamed from: mc java.awt.Image[]
    Image[] animatedBlockAnimation2 = new Image[50];
    // $FF: renamed from: nc int
    int numberOfLevels;
    // $FF: renamed from: oc int[]
    int[] levelFleaPopulation = new int[50];
    // $FF: renamed from: pc int[]
    int[] levelFleasToRescue = new int[50];
    // $FF: renamed from: qc java.lang.String[]
    String[] levelPasswords = new String[50];
    // $FF: renamed from: rc char[]
    char[] levelBlocks = new char[40000];
    // $FF: renamed from: sc java.awt.Color
    Color grey150 = new Color(150, 150, 150);
    // $FF: renamed from: tc java.awt.Color
    Color white200 = new Color(200, 200, 200);
    // $FF: renamed from: uc java.awt.Color
    Color black50 = new Color(50, 50, 50);

    // $FF: renamed from: g () void
    public void eraseSelectedTool() {
        short toolY = 357;
        int toolX = 114 + this.gamePadding;
        this.uiGraphics.setColor(Color.black);
        this.uiGraphics.drawRect(toolX, toolY, 26, 26);
        this.uiGraphics.drawRect(toolX + 1, toolY + 1, 24, 24);
        toolX = 232 + this.gamePadding;
        this.uiGraphics.setColor(Color.black);
        this.uiGraphics.drawRect(toolX, toolY, 26, 26);
        this.uiGraphics.drawRect(toolX + 1, toolY + 1, 24, 24);
        toolX = 349 + this.gamePadding;
        this.uiGraphics.setColor(Color.black);
        this.uiGraphics.drawRect(toolX, toolY, 26, 26);
        this.uiGraphics.drawRect(toolX + 1, toolY + 1, 24, 24);
    }

    // $FF: renamed from: a (java.awt.Graphics, int, int, int, int, java.lang.String) void
    public void drawButton(Graphics g, int x, int y, int buttonWidth, int buttonHeight, String text) {
        g.setColor(this.black50);
        g.fillRect(x + 2, y + 2, buttonWidth, buttonHeight);
        g.setColor(this.white200);
        g.fillRect(x - 1, y - 1, buttonWidth, buttonHeight);
        g.setColor(this.grey150);
        g.fillRect(x, y, buttonWidth, buttonHeight);
        this.uiGraphics.setColor(Color.black);
        this.drawCenteredText(g, text, this.helvetica13_, x + buttonWidth / 2, y + buttonHeight / 2);
    }

    // $FF: renamed from: c (int, int) void
    public void handleClick(int x, int y) {
        if (y < 336 && y > 0 && x > 0 && x < 640) {
            int clickedBlockX = x / 16;
            int clickedBlockY = y / 16;
            int clickedWalkX = clickedBlockX * 4;
            int clickedWalkY = clickedBlockY * 4;

            for(x = clickedWalkX; x < clickedWalkX + 4; ++x) {
                for(y = clickedWalkY; y < clickedWalkY + 4; ++y) {
                    if (this.walkBlockCollisionType[x][y] != 0) {
                        return;
                    }
                }
            }

            this.playSound(5); // block place
            this.curLevelBlocks[clickedBlockX][clickedBlockY] = (char)(this.selectedTool + 1);
            this.activateBlock(clickedBlockX, clickedBlockY);

            for(x = clickedWalkX; x < clickedWalkX + 4; ++x) {
                for(y = clickedWalkY; y < clickedWalkY + 4; ++y) {
                    if (this.selectedTool == 1) {
                        this.walkBlockCollisionType[x][y] = 1;
                    }

                    if (this.selectedTool == 2 && x - clickedWalkX == 3 - (y - clickedWalkY)) {
                        this.walkBlockCollisionType[x][y] = 1;
                    }

                    if (this.selectedTool == 3 && x - clickedWalkX == y - clickedWalkY) {
                        this.walkBlockCollisionType[x][y] = 1;
                    }
                }
            }
        }

    }

    // $FF: renamed from: d (int, int) void
    public void animateBlock(int blockX, int blockY) {
        this.updateBlockAndSurrounding(blockX, blockY);

        for(int curBlock = 0; curBlock < this.numberOfChangingBlocks; ++curBlock) {
            char curBlockId = this.curLevelBlocks[this.changingBlockX[curBlock]][this.changingBlockY[curBlock]];
            if (curBlockId == this.changingBlockIdBefore[curBlock] || curBlockId == this.changingBlockIdAfter[curBlock]) {
                int curBlockX = this.changingBlockX[curBlock] - blockX;
                if (curBlockX < 0) {
                    curBlockX = -curBlockX;
                }

                int curBlockY = this.changingBlockY[curBlock] - blockY;
                if (curBlockY < 0) {
                    curBlockY = -curBlockY;
                }

                if (curBlockX < 2 && curBlockY < 2) {
                    int changingBlockX = this.changingBlockX[curBlock];
                    int changingBlockY = this.changingBlockY[curBlock];
                    int idBefore = this.changingBlockIdBefore[curBlock];
                    int idAfter = this.changingBlockIdAfter[curBlock];

                    this.curLevelBlocks[changingBlockX][changingBlockY] = (char)idBefore;
                    this.updateBlockAndSurrounding(changingBlockX, changingBlockY);
                    this.uiGraphics = this.animatedBlockAnimation1[curBlock].getGraphics();
                    this.uiGraphics.drawImage(this.gameImage, 0, 0, this);

                    this.curLevelBlocks[changingBlockX][changingBlockY] = (char)idAfter;
                    this.updateBlockAndSurrounding(changingBlockX, changingBlockY);
                    this.uiGraphics = this.animatedBlockAnimation2[curBlock].getGraphics();
                    this.uiGraphics.drawImage(this.gameImage, 0, 0, this);

                    this.uiGraphics = this.uiImage.getGraphics();
                }
            }
        }

    }

    // $FF: renamed from: a (int, int, int, int) void
    public void handleFleaCollision(int walkX, int walkY, int collisionType, int fleaId) {
        boolean handleBlockWalkedOnDestroyed = false;
        int i;
        int j;
        int x;
        int y;

        // Bomb
        if (this.curLevelBlocks[walkX][walkY] == 10) {
            this.playSound(2); // explosion sound

            for(i = walkX - 1; i <= walkX + 1; ++i) {
                for(j = walkY - 1; j <= walkY + 1; ++j) {
                    this.curLevelBlocks[i][j] = 0;
                    this.activateBlock(i, j);

                    for(x = 0; x < 4; ++x) {
                        for(y = 0; y < 4; ++y) {
                            this.walkBlockCollisionType[i * 4 + x][j * 4 + y] = 0;
                        }
                    }
                }
            }
        }

        // Balloon
        if (this.curLevelBlocks[walkX][walkY] == 5) {
            this.playSound(1);
            this.curLevelBlocks[walkX][walkY] = 0;
            this.activateBlock(walkX, walkY);
            this.fleaGoingUpType[fleaId] = 1;

            for(x = 0; x < 4; ++x) {
                for(y = 0; y < 4; ++y) {
                    this.walkBlockCollisionType[walkX * 4 + x][walkY * 4 + y] = 0;
                }
            }
        }

        // Spring
        if (this.curLevelBlocks[walkX][walkY] == 6 && collisionType == 2) {
            this.fleaGoingUpType[fleaId] = 2;
            this.playSound(9); // Spring sound
        }

        // Spider Trigger block
        if (this.curLevelBlocks[walkX][walkY] == 7 && collisionType == 2 && this.spiderIsAffectedByAntiGravity == 0) {
            j = this.numberOfSpiders;

            for(i = 0; i < this.numberOfSpiders; ++i) {
                if (this.spiderX[i] == walkX && this.spiderY[i] == walkY) {
                    j = i;
                }
            }

            this.spiderSpeed[j] = 4;
            if (j == this.numberOfSpiders) {
                this.spiderX[j] = walkX;
                this.spiderY[j] = walkY;
                this.spiderVerticalProgress[j] = 0;
                this.curLevelBlocks[walkX][walkY - 2] = 30;
                this.activateBlock(walkX, walkY - 2);
                ++this.numberOfSpiders;
                this.uiGraphics = this.uiImage.getGraphics();
                this.uiGraphics.copyArea(walkX * 16, (walkY - 2) * 16 + this.spiderVerticalProgress[j], 20, 20, j * 20 - walkX * 16, 412 - (walkY - 2) * 16 - this.spiderVerticalProgress[j]);
            }
        }

        // Water top less choppy
        if (this.curLevelBlocks[walkX][walkY] == 13 && collisionType != 3) {
            this.fleaInactive[fleaId] = 1;
            this.playFleaDeathSound();
        }

        // Choppy water top
        if (this.curLevelBlocks[walkX][walkY] == 27 && collisionType != 3) {
            this.fleaInactive[fleaId] = 1;
            this.playFleaDeathSound();
        }

        // Teleporter block
        if (this.curLevelBlocks[walkX][walkY] == 16 || this.curLevelBlocks[walkX][walkY] == 29) {
            int newX;
            int newY;
            if (walkX == this.teleporterBlock1XCoord && walkY == this.teleporterBlock1YCoord) {
                newX = this.teleporterBlock2XCoord;
                newY = this.teleporterBlock2YCoord;
            } else {
                newX = this.teleporterBlock1XCoord;
                newY = this.teleporterBlock1YCoord;
            }

            if (this.curLevelBlocks[newX][newY] == 16 || this.curLevelBlocks[newX][newY] == 29) {
                // flea going right
                if (this.fleaHorizontalSpeed[fleaId] > 0 && this.walkBlockCollisionType[newX * 4 + 4][newY * 4] <= 0) {
                    this.fleaX[fleaId] = newX * 16 + 16;
                    this.fleaY[fleaId] = newY * 16;
                    this.playSound(10); // triumphant chord; warp sound
                }

                // flea going left
                if (this.fleaHorizontalSpeed[fleaId] < 0 && this.walkBlockCollisionType[newX * 4 - 1][newY * 4] <= 0) {
                    this.fleaX[fleaId] = newX * 16 - 4;
                    this.fleaY[fleaId] = newY * 16;
                    this.playSound(10); // triumphant chord; warp sound
                }
            }
        }

        // Flea exit
        if (this.curLevelBlocks[walkX][walkY] == 17) {
            this.fleaInactive[fleaId] = 1;
            ++this.fleasRescued;
            this.playSound(8); // flea rescue sound
        }

        // Anti-Gravity block
        if (this.curLevelBlocks[walkX][walkY] == 19 && this.antiGravityBlockCooldown == 0) { // anti-gravity
            this.playSound(0);
            this.gravityDirectionPixel1 = -this.gravityDirectionPixel1;
            this.gravityDirectionWalk4 = -this.gravityDirectionWalk4;
            this.gravityDirectionBlock16 = -this.gravityDirectionBlock16;
            this.spiderIsAffectedByAntiGravity = 4 - this.spiderIsAffectedByAntiGravity;
            this.antiGravityBlockCooldown = 3;
            if (collisionType < 2) {
                this.fleaHorizontalSpeed[fleaId] = -this.fleaHorizontalSpeed[fleaId];
            }
        }

        // 1 touch wall
        if (this.curLevelBlocks[walkX][walkY] == 21 && collisionType < 2) {
            this.playSound(3);
            this.curLevelBlocks[walkX][walkY] = 0;
            this.activateBlock(walkX, walkY);
            this.fleaHorizontalSpeed[fleaId] = -this.fleaHorizontalSpeed[fleaId];

            for(x = 0; x < 4; ++x) {
                for(y = 0; y < 4; ++y) {
                    this.walkBlockCollisionType[walkX * 4 + x][walkY * 4 + y] = 0;
                }
            }
        }

        // 1 use bridge: id 22
        // 1 use bridge that looks like a Basic Wall (jerk move tbh): id 26
        handleBlockWalkedOnDestroyed = false;
        if (this.curLevelBlocks[walkX][walkY] == 22) {
            handleBlockWalkedOnDestroyed = true;
        }
        if (this.curLevelBlocks[walkX][walkY] == 26) {
            handleBlockWalkedOnDestroyed = true;
        }
        if (handleBlockWalkedOnDestroyed && collisionType == 2) {
            i = walkX - this.fleaHorizontalSpeed[fleaId] / 4;
            if (this.curLevelBlocks[i][walkY] == 22) {
                this.playSound(3);
                this.curLevelBlocks[i][walkY] = 0;
                this.activateBlock(i, walkY);

                for(x = 0; x < 4; ++x) {
                    for(y = 0; y < 4; ++y) {
                        this.walkBlockCollisionType[i * 4 + x][walkY * 4 + y] = 0;
                    }
                }
            }
        }

        // Blue button (opens yellow barriers)
        if (this.curLevelBlocks[walkX][walkY] == 23) {
            this.playSound(4);

            for(i = 0; i < 40; ++i) {
                for(j = 0; j < 21; ++j) {
                    if (this.curLevelBlocks[i][j] == 23 || this.curLevelBlocks[i][j] == 20) {
                        this.curLevelBlocks[i][j] = 0;
                        this.activateBlock(i, j);

                        for(x = 0; x < 4; ++x) {
                            for(y = 0; y < 4; ++y) {
                                this.walkBlockCollisionType[i * 4 + x][j * 4 + y] = 0;
                            }
                        }
                    }
                }
            }
        }

        // Green button (causes all recessed walls to slide out)
        if (this.curLevelBlocks[walkX][walkY] == 24) {
            this.playSound(4);

            for(i = 0; i < 40; ++i) {
                for(j = 0; j < 21; ++j) {
                    if (this.curLevelBlocks[i][j] == 24) {
                        this.curLevelBlocks[i][j] = 0;
                        this.activateBlock(i, j);

                        for(x = 0; x < 4; ++x) {
                            for(y = 0; y < 4; ++y) {
                                this.walkBlockCollisionType[i * 4 + x][j * 4 + y] = 0;
                            }
                        }
                    }

                    if (this.curLevelBlocks[i][j] == 18) {
                        this.curLevelBlocks[i][j] = 2;
                        this.activateBlock(i, j);

                        for(x = 0; x < 4; ++x) {
                            for(y = 0; y < 4; ++y) {
                                this.walkBlockCollisionType[i * 4 + x][j * 4 + y] = 1;
                            }
                        }
                    }
                }
            }
        }

        // Spikes block (looks like grass)
        if (this.curLevelBlocks[walkX][walkY] == 25 && collisionType != 3) {
            this.fleaInactive[fleaId] = 1;
            this.playFleaDeathSound();
        }

    }

    public fleas() {
    }

    // $FF: renamed from: a (java.lang.String, int, int) java.awt.Image[]
    public Image[] loadImages(String imageName, int width, int height) {
        Image image = JagLoader.getImage(imageName);
        int imageWidth = image.getWidth(this);
        int imageHeight = image.getHeight(this);
        int[] imagePixels = new int[imageWidth * imageHeight];
        PixelGrabber pixelGrabber = new PixelGrabber(image, 0, 0, imageWidth, imageHeight, imagePixels, 0, imageWidth);

        try {
            pixelGrabber.grabPixels();
        } catch (InterruptedException ex) {
            System.out.println("Error!");
        }

        int imgWidthIdx = 0;
        int imgHeightIdx = 0;
        int numberOfImages = imageWidth / width * (imageHeight / height);
        Image[] fleaImages = new Image[numberOfImages];

        for(int i = 0; i < numberOfImages; ++i) {
            int p = 0;
            int[] pixelArray = new int[width * height];

            for(int y = imgHeightIdx; y < imgHeightIdx + height; ++y) {
                for(int x = imgWidthIdx; x < imgWidthIdx + width; ++x) {
                    pixelArray[p++] = imagePixels[x + y * imageWidth];
                }
            }

            fleaImages[i] = this.createImage(new MemoryImageSource(width, height, pixelArray, 0, width));

            while(!this.prepareImage(fleaImages[i], this)) {
                ;
            }

            imgWidthIdx += width;
            if (imgWidthIdx >= imageWidth) {
                imgWidthIdx = 0;
                imgHeightIdx += height;
            }
        }

        return fleaImages;
    }

    public boolean mouseUp(Event event, int mouseX, int mouseY) {
        this.mouseClickX = mouseX;
        this.mouseClickY = mouseY;
        this.clickType = 0;
        return true;
    }

    // $FF: renamed from: b (int, int, int, int) void
    public void registerBlockChange(int blockX, int blockY, int blockIdBeforeChange, int blockIdAfterChange) {
        this.changingBlockX[this.numberOfChangingBlocks] = blockX;
        this.changingBlockY[this.numberOfChangingBlocks] = blockY;
        this.changingBlockIdBefore[this.numberOfChangingBlocks] = blockIdBeforeChange;
        this.changingBlockIdAfter[this.numberOfChangingBlocks] = blockIdAfterChange;
        this.isSpinningPlatform[this.numberOfChangingBlocks] = 0;

        this.curLevelBlocks[blockX][blockY] = (char)blockIdBeforeChange;
        this.updateBlockAndSurrounding(blockX, blockY);
        this.uiGraphics = this.animatedBlockAnimation1[this.numberOfChangingBlocks].getGraphics();
        this.uiGraphics.drawImage(this.gameImage, 0, 0, this);

        this.curLevelBlocks[blockX][blockY] = (char)blockIdAfterChange;
        this.updateBlockAndSurrounding(blockX, blockY);
        this.uiGraphics = this.animatedBlockAnimation2[this.numberOfChangingBlocks].getGraphics();
        this.uiGraphics.drawImage(this.gameImage, 0, 0, this);

        ++this.numberOfChangingBlocks;
    }

    // $FF: renamed from: e () void
    public void processGameLogic() {
        this.uiGraphics = this.uiImage.getGraphics();
        Graphics g = this.getGraphics();
        if (this.titleScreenState == 10) {
            // You are a winner today!
            if (this.titleScreenState != this.lastTitleScreenState) {
                this.uiGraphics.setColor(Color.black);
                this.uiGraphics.fillRect(0, 0, 650, 400);
                this.uiGraphics.drawImage(this.titlePicture, 64, 63, this);
                this.drawCenteredText(this.uiGraphics, "Congratulations", this.helvetica50, 325, 130);
                this.drawCenteredText(this.uiGraphics, "You have completed", this.helvetica50, 325, 200);
                this.drawCenteredText(this.uiGraphics, "Flea Circus", this.helvetica50, 325, 270);
                this.lastTitleScreenState = this.titleScreenState;
            }

            g.drawImage(this.uiImage, 0, 0, this);
        } else {
            int i;
            if (this.titleScreenState > 0) {
                // Not playing Flea Circus yet
                if (this.titleScreenState != this.lastTitleScreenState) {
                    this.uiGraphics.setColor(Color.black);
                    this.uiGraphics.fillRect(0, 0, 650, 400);
                    this.uiGraphics.drawImage(this.titlePicture, 64, 63, this);
                    this.drawCenteredText(this.uiGraphics, "Flea Circus", this.helvetica90, 325, 150);
                    this.drawCenteredText(this.uiGraphics, "Programming: Andrew Gower", this.helvetica20b, 325, 210);
                    this.drawCenteredText(this.uiGraphics, "Level Design: Paul Gower", this.helvetica20b, 325, 230);
                    this.lastTitleScreenState = this.titleScreenState;
                }

                if (this.titleScreenState == 1) {
                    // Initial Screen
                    this.drawButton(this.uiGraphics, 202, 279, 100, 30, "Start New Game");
                    this.drawButton(this.uiGraphics, 345, 279, 100, 30, "Continue Game");
                    if (this.mouseIsHeldDown == 1) {
                    		// "Start New Game" button
                        if (this.mouseClickX > 202 && this.mouseClickY > 279 && this.mouseClickX < 302 && this.mouseClickY < 309) {
                            this.levelIndex = 0;
                            this.startLevel();
                        }

                        // "Continue Game" button
                        if (this.mouseClickX > 345 && this.mouseClickY > 279 && this.mouseClickX < 445 && this.mouseClickY < 309) {
                            this.titleScreenState = 2; // show "Enter password:" screen
                            super.passwordDisplay = "";
                            super.passwordEntered = "";
                        }

                        this.mouseIsHeldDown = 0;
                    }
                }

                if (this.titleScreenState == 2) {
                    // Password Entry Screen
                    this.drawButton(this.uiGraphics, 175, 279, 300, 30, "Enter password here: " + super.passwordDisplay + "*");
                    if (super.passwordEntered.length() > 0) {
                        this.levelIndex = 0;

                        for(i = 0; i < this.numberOfLevels; ++i) {
                            if (super.passwordEntered.equalsIgnoreCase(this.levelPasswords[i])) {
                                this.levelIndex = i;
                            }
                        }

                        this.startLevel();
                    }
                }

                g.drawImage(this.uiImage, 0, 0, this);
            } else {
                this.lastTitleScreenState = this.titleScreenState;
                if (this.mouseIsHeldDown == 1) {
                		// "Pause" button
                    if (this.mouseClickX > 480 && this.mouseClickY > 355 && this.mouseClickX < 530 && this.mouseClickY < 380) {
                        this.pauseState = 1 - this.pauseState;
                        this.clickType = 0;
                    }

                    // "Quit" button
                    if (this.mouseClickX > 540 && this.mouseClickY > 355 && this.mouseClickX < 580 && this.mouseClickY < 380 && this.pauseState == 0) {
                        this.titleScreenState = 1; // go back to title screen
                    }

                    // "Restart" button
                    if (this.mouseClickX > 590 && this.mouseClickY > 355 && this.mouseClickX < 630 && this.mouseClickY < 380 && this.pauseState == 0) {
                        this.startLevel();
                    }

                    this.mouseIsHeldDown = 0;
                }

                if (this.pauseState == 0) {
                    this.drawButton(this.uiGraphics, 480, 355, 50, 25, "Pause");
                } else {
                    this.drawButton(this.uiGraphics, 480, 355, 50, 25, "Resume");
                }

                this.drawButton(this.uiGraphics, 540, 355, 40, 25, "Quit");
                this.drawButton(this.uiGraphics, 590, 355, 40, 25, "Restart");
                if (this.pauseState == 1) {
                    // game is paused
                    g.drawImage(this.uiImage, 0, 0, this);
                } else {
                    // game is not paused, we are playing
                    this.animationFrame = (this.animationFrame + 1) % 8;

                    // Handle block animations logic
                    int x;
                    int y;
                    int j;
                    for(i = 0; i < this.numberOfChangingBlocks; ++i) {
                        char curBlockId = this.curLevelBlocks[this.changingBlockX[i]][this.changingBlockY[i]];
                        if (curBlockId == this.changingBlockIdBefore[i] || curBlockId == this.changingBlockIdAfter[i]) {
                            if (this.isSpinningPlatform[i] == 0) {
                                if (this.animationFrame == 3) {
                                    this.uiGraphics.drawImage(this.animatedBlockAnimation1[i], this.changingBlockX[i] * 16, this.changingBlockY[i] * 16, this);
                                }

                                if (this.animationFrame == 7) {
                                    this.uiGraphics.drawImage(this.animatedBlockAnimation2[i], this.changingBlockX[i] * 16, this.changingBlockY[i] * 16, this);
                                }
                            } else if (this.changingBlockIdBefore[i] == 9) {
                                // Spinning platform vertical
                                x = this.changingBlockX[i] * 16;
                                y = this.changingBlockY[i] * 16;
                                boolean spinningPlatformShouldBeVerticalStill = false;

                                for(j = 0; j < this.fleasReleased; ++j) {
                                    if (this.fleaInactive[j] == 0 && this.fleaX[j] >= x && this.fleaY[j] >= y && this.fleaX[j] < x + 16 && this.fleaY[j] < y + 16) {
                                        spinningPlatformShouldBeVerticalStill = true;
                                    }
                                }

                                if (spinningPlatformShouldBeVerticalStill) {
                                    this.uiGraphics.drawImage(this.animatedBlockAnimation1[i], x, y, this);
                                } else {
                                    this.uiGraphics.drawImage(this.animatedBlockAnimation2[i], x, y, this);
                                }
                            }
                        }
                    }

                    // Handle flea deployment
                    if (this.fleasReleased < this.fleasToRelease) {
                        this.countdownToFleaRelease -= 1;
                        if (this.countdownToFleaRelease < 1) {
                            this.countdownToFleaRelease = 6;
                            ++this.fleasReleased;
                        }
                    }

                    // Handle game logic for each flea
                    int walkX;
                    int walkY;
                    for(i = 0; i < this.fleasReleased; ++i) {
                        if (this.fleaInactive[i] == 0 && this.fleaGoingUpType[i] != 1 && this.curLevelBlocks[this.fleaX[i] / 16][this.fleaY[i] / 16] == 2) {
                            this.fleaInactive[i] = 1;
                            this.playFleaDeathSound();
                            this.uiGraphics.copyArea(i * 16, 396, 4, 4, this.fleaX[i] + 4 - i * 16, this.fleaY[i] + this.antiGravityYOffset - 396);
                        }

                        if (this.fleaInactive[i] == 0) {
                            x = this.fleaX[i];
                            y = this.fleaY[i];
                            int fleaSpeed = this.fleaHorizontalSpeed[i];
                            int blockX = x / 4;
                            int blockY = y / 4;
                            int fleaSpeedNormalized = fleaSpeed / 4;
                            if (this.fleaGoingUpType[i] != 1) {
                                this.uiGraphics.copyArea(i * 16, 396, 4, 4, x + 4 - i * 16, y + this.antiGravityYOffset - 396);
                            }

                            // set flea animation
                            if (fleaSpeed < 0) {
                                this.fleaWalkAnimation[i] = this.animationFrame % 2;
                            } else {
                                this.fleaWalkAnimation[i] = 2 + this.animationFrame % 2;
                            }

                            // handle fans
                            boolean fleaPushedByFan = false;
                            for(j = 0; j < this.numberOfFans; ++j) {
                                if (x >= this.fanXPixelLeft[j] && x < this.fanXPixelRight[j] && y >= this.fanYPixelTop[j] && y < this.fanYPixelBottom[j] && this.fanExploded[j] == 0) {
                                    if (x / 16 > this.fanX[j]) {
                                        this.fleaHorizontalSpeed[i] = 4;
                                        fleaSpeed = 4;
                                        fleaSpeedNormalized = 1;
                                    } else {
                                        this.fleaHorizontalSpeed[i] = -4;
                                        fleaSpeed = -4;
                                        fleaSpeedNormalized = -1;
                                    }

                                    fleaPushedByFan = true;
                                }
                            }

                            if (this.fleaGoingUpType[i] != 0) {
                                if (this.fleaGoingUpType[i] == 1) {
                                    this.uiGraphics.copyArea(i * 16, 396, 16, 20, x - 2 - i * 16, y - 16 - 396);
                                    y -= this.gravityDirectionWalk4;
                                    walkX = x / 16;
                                    walkY = y / 16;
                                    if (this.curLevelBlocks[walkX][walkY] == 11 && y % 16 == 4) {
                                        this.fleaGoingUpType[i] = 0;
                                        this.fleaHorizontalSpeed[i] = -4;
                                        fleaSpeed = -4;
                                    }
                                }

                                if (this.fleaGoingUpType[i] == 2) {
                                    this.walkBlockCollisionType[blockX][blockY] = 0;
                                    if (this.walkBlockCollisionType[blockX][blockY - this.gravityDirectionPixel1] == 2) {
                                        this.handleFleaCollision(blockX / 4, (blockY - 1) / 4, 3, i);
                                    }

                                    x = this.fleaX[i];
                                    y = this.fleaY[i];
                                    fleaSpeed = this.fleaHorizontalSpeed[i];
                                    blockX = x / 4;
                                    blockY = y / 4;
                                    fleaSpeedNormalized = fleaSpeed / 4;
                                    y -= this.gravityDirectionWalk4;
                                    blockY -= this.gravityDirectionPixel1;
                                    if (this.walkBlockCollisionType[blockX][blockY] > 0 || fleaPushedByFan) {
                                        y += this.gravityDirectionWalk4;
                                        blockY += this.gravityDirectionPixel1;
                                        this.fleaGoingUpType[i] = 0;
                                    }

                                    this.walkBlockCollisionType[blockX][blockY] = 1;
                                }
                            } else {
                                this.walkBlockCollisionType[blockX][blockY] = 0;
                                if (this.walkBlockCollisionType[blockX][blockY + this.gravityDirectionPixel1] == 2 && !fleaPushedByFan) {
                                    this.handleFleaCollision(blockX / 4, (blockY + this.gravityDirectionPixel1) / 4, 2, i);
                                }

                                if (this.walkBlockCollisionType[blockX][blockY - this.gravityDirectionPixel1] == 2 && !fleaPushedByFan) {
                                    this.handleFleaCollision(blockX / 4, (blockY - this.gravityDirectionPixel1) / 4, 3, i);
                                }

                                if ((this.walkBlockCollisionType[blockX][blockY + this.gravityDirectionPixel1] > 0 || fleaPushedByFan) && this.walkBlockCollisionType[blockX + fleaSpeedNormalized][blockY] == 2) {
                                    this.handleFleaCollision((blockX + fleaSpeedNormalized) / 4, blockY / 4, fleaSpeedNormalized, i);
                                }

                                x = this.fleaX[i];
                                y = this.fleaY[i];
                                fleaSpeed = this.fleaHorizontalSpeed[i];
                                blockX = x / 4;
                                blockY = y / 4;
                                fleaSpeedNormalized = fleaSpeed / 4;
                                if (this.fleaGoingUpType[i] != 2) {
                                    if (this.walkBlockCollisionType[blockX][blockY + this.gravityDirectionPixel1] <= 0 && !fleaPushedByFan) {
                                        y += this.gravityDirectionWalk4;
                                    } else if (this.walkBlockCollisionType[blockX + fleaSpeedNormalized][blockY] > 0 && this.walkBlockCollisionType[blockX][blockY - this.gravityDirectionPixel1] <= 0 && this.walkBlockCollisionType[blockX + fleaSpeedNormalized][blockY - this.gravityDirectionPixel1] <= 0) {
                                        x += fleaSpeed;
                                        y -= this.gravityDirectionWalk4;
                                    } else if (this.walkBlockCollisionType[blockX + fleaSpeedNormalized][blockY] <= 0) {
                                        x += fleaSpeed;
                                    } else {
                                        fleaSpeed = -fleaSpeed;
                                    }
                                }

                                blockX = x / 4;
                                blockY = y / 4;
                                if (this.fleaGoingUpType[i] != 1 && this.fleaInactive[i] == 0) {
                                    this.walkBlockCollisionType[blockX][blockY] = 1;
                                }
                            }

                            this.fleaX[i] = x;
                            this.fleaY[i] = y;
                            this.fleaHorizontalSpeed[i] = fleaSpeed;
                        }
                    }

                    // handle additional game logic
                    for(i = 0; i < this.numberOfSpiders; ++i) {
                        walkX = this.spiderX[i];
                        walkY = this.spiderY[i];
                        x = walkX * 16;
                        y = (walkY - 2) * 16 + this.spiderVerticalProgress[i];

                        for(j = 0; j < this.fleasReleased; ++j) {
                            if (this.fleaX[j] >= x - 4 && this.fleaX[j] < x + 20 && this.fleaY[j] >= y && this.fleaY[j] < y + 20) {
                                if (this.fleaInactive[j] == 0) {
                                    this.fleaInactive[j] = 1;
                                    this.playFleaDeathSound();
                                }

                                this.uiGraphics.copyArea(j * 16, 396, 4, 4, this.fleaX[j] + 4 - j * 16, this.fleaY[j] - 396);
                                this.walkBlockCollisionType[this.fleaX[j] / 4][this.fleaY[j] / 4] = 0;
                            }
                        }

                        this.uiGraphics.copyArea(i * 20, 412, 20, 20, walkX * 16 - i * 20, (walkY - 2) * 16 + this.spiderVerticalProgress[i] - 412);
                        this.spiderVerticalProgress[i] += this.spiderSpeed[i];
                        if (this.spiderVerticalProgress[i] >= 16) {
                            this.spiderVerticalProgress[i] = 16;
                            this.spiderSpeed[i] = -4;
                        }

                        if (this.spiderVerticalProgress[i] == 0) {
                            this.curLevelBlocks[walkX][walkY - 2] = 15;
                            this.activateBlock(walkX, walkY - 2); // activate the spider

                            for(j = i; j < this.numberOfSpiders; ++j) {
                                this.spiderX[j] = this.spiderX[j + 1];
                                this.spiderY[j] = this.spiderY[j + 1];
                                this.spiderVerticalProgress[j] = this.spiderVerticalProgress[j + 1];
                                this.spiderSpeed[j] = this.spiderSpeed[j + 1];
                                this.uiGraphics.copyArea((j + 1) * 20, 412, 20, 20, -20, 0);
                            }

                            this.numberOfSpiders -= 1;
                        }
                    }

                    for(i = 0; i < this.blocksToAnimate; ++i) {
                        this.animateBlock(this.animateBlockX[i], this.animateBlockY[i]);
                    }

                    this.blocksToAnimate = 0;
                    this.antiGravityYOffset = this.spiderIsAffectedByAntiGravity;
                    if (this.antiGravityBlockCooldown > 0) {
                        this.antiGravityBlockCooldown -= 1;
                    }

                    for(i = 0; i < this.fleasToRelease; ++i) {
                        if (this.fleaGoingUpType[i] == 1) {
                            this.uiGraphics.copyArea(this.fleaX[i] - 2, this.fleaY[i] - 16, 16, 20, i * 16 - (this.fleaX[i] - 2), 396 - (this.fleaY[i] - 16));
                        } else if (this.fleaInactive[i] == 0) {
                            this.uiGraphics.copyArea(this.fleaX[i] + 4, this.fleaY[i] + this.antiGravityYOffset, 4, 4, i * 16 - (this.fleaX[i] + 4), 396 - (this.fleaY[i] + this.antiGravityYOffset));
                        }
                    }

                    for(i = 0; i < this.numberOfSpiders; ++i) {
                        walkX = this.spiderX[i];
                        walkY = this.spiderY[i];
                        this.uiGraphics.copyArea(walkX * 16, (walkY - 2) * 16 + this.spiderVerticalProgress[i], 20, 20, i * 20 - walkX * 16, 412 - (walkY - 2) * 16 - this.spiderVerticalProgress[i]);
                    }

                    for(i = 0; i < this.fleasReleased; ++i) {
                        if (this.fleaGoingUpType[i] == 1) {
                            this.uiGraphics.drawImage(this.blockPictures[5], this.fleaX[i] - 4, this.fleaY[i] - 16, this);
                            this.uiGraphics.drawImage(this.fleaPictures[this.fleaWalkAnimation[i]], this.fleaX[i] + 4, this.fleaY[i], this);
                        } else if (this.fleaInactive[i] == 0) {
                            this.uiGraphics.drawImage(this.fleaPictures[this.fleaWalkAnimation[i]], this.fleaX[i] + 4, this.fleaY[i] + this.antiGravityYOffset, this);
                        }
                    }

                    for(i = 0; i < this.numberOfSpiders; ++i) {
                        walkX = this.spiderX[i];
                        walkY = this.spiderY[i];
                        this.uiGraphics.drawImage(this.blockPictures[15], walkX * 16, (walkY - 2) * 16 + this.spiderVerticalProgress[i], this);
                    }

                    g.drawImage(this.uiImage, 0, 0, this);
                    if (this.clickType == 1) {
                        this.handleClick(this.mouseClickX, this.mouseClickY);
                    }

                    if (this.fleasRescued == this.levelFleasToRescue[this.levelIndex]) {
                        ++this.levelIndex;
                        if (this.levelIndex == this.numberOfLevels) {
                            this.titleScreenState = 10;
                        } else {
                            this.startLevel();
                        }
                    }

                }
            }
        }
    }

    // $FF: renamed from: h () void
    public void resetFleas() {
        this.uiGraphics = this.uiImage.getGraphics();

        for(int fleaId = 0; fleaId < 40; ++fleaId) {
            this.fleaX[fleaId] = this.fleaStartX;
            this.fleaY[fleaId] = this.fleaStartY;
            this.fleaHorizontalSpeed[fleaId] = -4;
            this.fleaInactive[fleaId] = 0;
            this.fleaGoingUpType[fleaId] = 0;
            this.fleasReleased = 0;
            this.countdownToFleaRelease = 200;
            this.fleaWalkAnimation[fleaId] = 0;
            this.walkBlockCollisionType[this.fleaX[fleaId] / 4][this.fleaY[fleaId] / 4] = 1;
            this.uiGraphics.copyArea(this.fleaX[fleaId] + 4, this.fleaY[fleaId], 4, 4, fleaId * 16 - (this.fleaX[fleaId] + 4), 396 - this.fleaY[fleaId]);
        }

    }

    // $FF: renamed from: e (int, int) void
    public void highlightSelectedTool(int toolX, int toolY) {
        this.uiGraphics.setColor(Color.blue);
        this.uiGraphics.drawRect(toolX, toolY, 26, 26);
        this.uiGraphics.setColor(new Color(0, 132, 255));
        this.uiGraphics.drawRect(toolX + 1, toolY + 1, 24, 24);
    }

    // $FF: renamed from: f (int, int) void
    public void updateBlockAndSurrounding(int blockX, int blockY) {
        this.uiGraphics = this.uiImage.getGraphics();
        this.gameGraphics = this.gameImage.getGraphics();
        this.gameGraphics.setColor(Color.black);
        this.gameGraphics.fillRect(0, 0, 20, 20);
        this.gameGraphics.drawImage(this.blockPictures[this.curLevelBlocks[blockX + 1][blockY + 1]], 16, 16, this);
        this.gameGraphics.drawImage(this.blockPictures[this.curLevelBlocks[blockX][blockY + 1]], 0, 16, this);
        this.gameGraphics.drawImage(this.blockPictures[this.curLevelBlocks[blockX - 1][blockY + 1]], -16, 16, this);
        this.gameGraphics.drawImage(this.blockPictures[this.curLevelBlocks[blockX + 1][blockY]], 16, 0, this);
        this.gameGraphics.drawImage(this.blockPictures[this.curLevelBlocks[blockX][blockY]], 0, 0, this);
        this.gameGraphics.drawImage(this.blockPictures[this.curLevelBlocks[blockX - 1][blockY]], -16, 0, this);
        this.gameGraphics.drawImage(this.blockPictures[this.curLevelBlocks[blockX + 1][blockY - 1]], 16, -16, this);
        this.gameGraphics.drawImage(this.blockPictures[this.curLevelBlocks[blockX][blockY - 1]], 0, -16, this);
        this.gameGraphics.drawImage(this.blockPictures[this.curLevelBlocks[blockX - 1][blockY - 1]], -16, -16, this);
        this.uiGraphics.drawImage(this.gameImage, blockX * 16, blockY * 16, this);
    }

    public static void main(String[] args) {
        fleas myFleas = new fleas();
        myFleas.launchAsApplication(644, 390, "Flea circus - By Andrew Gower", false);
    }

    // $FF: renamed from: b () void
    public void loadAssets() {
        this.setGameSpeed(40);
        this.helvetica13 = new Font("Helvetica", Font.PLAIN, 13);
        this.helvetica13_ = new Font("Helvetica", Font.PLAIN, 13);
        this.helvetica90 = new Font("Helvetica", Font.PLAIN, 90);
        this.helvetica36 = new Font("Helvetica", Font.PLAIN, 36);
        this.helvetica50 = new Font("Helvetica", Font.PLAIN, 50);
        this.helvetica20b = new Font("Helvetica", Font.BOLD, 20);
        this.updateLoadingBar(10);
        this.blockPictures = this.loadImages("blocks.gif", 20, 20);
        this.updateLoadingBar(20);
        this.fleaPictures = this.loadImages("fleas.gif", 4, 4);
        this.updateLoadingBar(30);
        this.titlePicture = JagLoader.getImage("title.gif");
        this.updateLoadingBar(50);
        byte[] soundEffects = null;
        byte[] levelData = null;

        try {
            byte[] fleasArchive = JagLoader.readFully("fleas.jag");
            soundEffects = JagLoader.extractBzippedFile("sfx.xm", 1000, fleasArchive);
            levelData = JagLoader.extractBzippedFile("levels.lev", 0, fleasArchive);
        } catch (Exception ex) {
            System.out.println("Fatal error loading fleas.jag");
        }

        this.updateLoadingBar(60);
        this.xmPlayer = new XMPlayer(soundEffects);
        this.xmPlayer.init();
        this.updateLoadingBar(70);
        this.loadLevelData(levelData);
        this.updateLoadingBar(100);
        this.uiImage = this.createImage(644, 440);
        this.gameImage = this.createImage(20, 20);

        for(int i = 0; i < 50; ++i) {
            this.animatedBlockAnimation1[i] = this.createImage(20, 20);
            this.animatedBlockAnimation2[i] = this.createImage(20, 20);
        }

        this.titleScreenState = 1;
        this.levelIndex = 0;
    }

    // $FF: renamed from: d (int) void
    public void playSound(int soundId) {
        this.xmPlayer.playSound(this.isPlayingSound, soundId, 8000, 63);
        this.isPlayingSound = 1 - this.isPlayingSound;
    }

    // $FF: renamed from: i () void
    public void playFleaDeathSound() {
        int random = (int)(Math.random() * 128.0D);
        if (random > 64) {
            this.playSound(6); // normal flea death cry
        } else {
            this.playSound(7); // higher pitched flea death cry
        }
    }

    // $FF: renamed from: b (byte[]) void
    public void loadLevelData(byte[] levelData) {
        byte fileBeginning = 0;
        int idx = fileBeginning + 1;
        this.numberOfLevels = levelData[fileBeginning] & 255;

        int i;
        for(i = 0; i < this.numberOfLevels; ++i) {
            byte[] strLengths = new byte[20];

            for(int j = 0; j < 20; ++j) {
                strLengths[j] = levelData[idx++];
            }

            this.levelPasswords[i] = (new String(strLengths)).trim();
        }

        for(i = 0; i < this.numberOfLevels; ++i) {
            this.levelFleaPopulation[i] = levelData[idx++] & 255;
        }

        for(i = 0; i < this.numberOfLevels; ++i) {
            this.levelFleasToRescue[i] = levelData[idx++] & 255;
        }

        for(i = 0; i < this.numberOfLevels * 840; ++i) {
            this.levelBlocks[i] = (char)(levelData[idx++] & 255);
        }

    }

    // $FF: renamed from: j () void
    public void handleFanBlowing() {
        for(int curFan = 0; curFan < this.numberOfFans; ++curFan) {
            int fanX = this.fanX[curFan];
            int fanY = this.fanY[curFan];
            int fanXPixelLeft = fanX * 16;
            int fanYPixelTop = fanY * 16;
            int fanXPixelRight = fanX * 16 + 20;
            int fanYPixelBottom = fanY * 16 + 16;
            if (this.curLevelBlocks[fanX][fanY] != 14 && this.curLevelBlocks[fanX][fanY] != 28) {
                this.fanExploded[curFan] = 1;
            }

            int curFanX;
            for(curFanX = fanX - 1; this.curLevelBlocks[curFanX][fanY] == 0; fanXPixelLeft -= 16) {
                --curFanX;
            }

            for(curFanX = fanX + 1; this.curLevelBlocks[curFanX][fanY] == 0; fanXPixelRight += 16) {
                ++curFanX;
            }

            this.fanXPixelLeft[curFan] = fanXPixelLeft;
            this.fanYPixelTop[curFan] = fanYPixelTop;
            this.fanXPixelRight[curFan] = fanXPixelRight;
            this.fanYPixelBottom[curFan] = fanYPixelBottom;
        }

    }

    // $FF: renamed from: k () void
    public void startLevel() {
        this.levelPostLoadSetup();
        this.drawLevel();
        this.resetFleas();
        this.titleScreenState = 0;
    }

    public boolean mouseDown(Event event, int mouseX, int mouseY) {
        this.mouseClickX = mouseX;
        this.mouseClickY = mouseY;
        this.clickType = 1;
        this.mouseIsHeldDown = 1;
        if (this.pauseState == 0 && this.titleScreenState == 0) {
            this.uiGraphics = this.uiImage.getGraphics();
            this.gameGraphics = this.gameImage.getGraphics();
            if (mouseX > 100 + this.gamePadding && mouseX < 160 + this.gamePadding && mouseY > 350) {
                this.eraseSelectedTool();
                this.selectedTool = 1;
                this.highlightSelectedTool(114 + this.gamePadding, 357);
            }

            if (mouseX > 210 + this.gamePadding && mouseX < 280 + this.gamePadding && mouseY > 350) {
                this.eraseSelectedTool();
                this.selectedTool = 2;
                this.highlightSelectedTool(232 + this.gamePadding, 357);
            }

            if (mouseX > 320 + this.gamePadding && mouseX < 390 + this.gamePadding && mouseY > 350) {
                this.eraseSelectedTool();
                this.selectedTool = 3;
                this.highlightSelectedTool(349 + this.gamePadding, 357);
            }

            this.handleClick(this.mouseClickX, this.mouseClickY);
        }

        return true;
    }

    // $FF: renamed from: g (int, int) void
    public void activateBlock(int walkX, int walkY) {
        this.animateBlockX[this.blocksToAnimate] = walkX;
        this.animateBlockY[this.blocksToAnimate] = walkY;
        ++this.blocksToAnimate;
        this.handleFanBlowing();
    }

    // $FF: renamed from: l () void
    public void levelPostLoadSetup() {
        this.numberOfChangingBlocks = 0;
        this.fleasRescued = 0;
        this.numberOfSpiders = 0;
        this.numberOfTeleporterBlocks = 0;
        this.numberOfFans = 0;
        this.pauseState = 0; // not paused
        this.gravityDirectionPixel1 = 1;
        this.gravityDirectionWalk4 = 4;
        this.gravityDirectionBlock16 = 16;
        this.spiderIsAffectedByAntiGravity = 0;
        this.antiGravityYOffset = 0;
        this.antiGravityBlockCooldown = 0;
        this.fleasToRelease = this.levelFleaPopulation[this.levelIndex];

        // Load level blocks as stored in archive to 2d array
        int x;
        int y;
        for(x = 0; x < 40; ++x) {
            for(y = 0; y < 21; ++y) {
                this.curLevelBlocks[x][y] = this.levelBlocks[this.levelIndex * 840 + x * 21 + y];
            }
        }

        // do some post-level-load setup
        for(x = 0; x < 40; ++x) {
            for(y = 0; y < 21; ++y) {
                // Spider
                if (this.curLevelBlocks[x][y] == 15) {
                    // Set the Spider Trigger Block
                    this.curLevelBlocks[x][y + 2] = 7;
                }

                // Flea Entrance
                if (this.curLevelBlocks[x][y] == 1) {
                    // Set fleaStart X & Y centered on the Entrance block
                    this.fleaStartX = x * 16 + 8;
                    this.fleaStartY = y * 16 + 16;
                }

                // Spinning platform horizontal
                if (this.curLevelBlocks[x][y] == 8) {
                    // animate & set as a spinning platform type block
                    this.registerBlockChange(x, y, 9, 8);
                    this.isSpinningPlatform[this.numberOfChangingBlocks - 1] = 1;
                }

                // Top of water
                if (this.curLevelBlocks[x][y] == 13) {
                    // animate the water
                    this.registerBlockChange(x, y, 13, 27);
                }

                // Fan in the + position
                if (this.curLevelBlocks[x][y] == 14) {
                    // animate the fan
                    this.registerBlockChange(x, y, 14, 28);

                    // register the fan
                    this.fanX[this.numberOfFans] = x;
                    this.fanY[this.numberOfFans] = y;
                    this.fanExploded[this.numberOfFans] = 0;
                    ++this.numberOfFans;
                }

                // Teleporter block blue center
                if (this.curLevelBlocks[x][y] == 16) {
                    if (this.numberOfTeleporterBlocks == 0) {
                        this.teleporterBlock1XCoord = x;
                        this.teleporterBlock1YCoord = y;
                        this.numberOfTeleporterBlocks = 1;
                    } else {
                        this.teleporterBlock2XCoord = x;
                        this.teleporterBlock2YCoord = y;
                        this.numberOfTeleporterBlocks = 2;
                    }

                    this.registerBlockChange(x, y, 16, 29);
                }
            }
        }

        this.handleFanBlowing();
    }

    public boolean mouseDrag(Event event, int mouseX, int mouseY) {
        this.mouseClickX = mouseX;
        this.mouseClickY = mouseY;
        return true;
    }

    // $FF: renamed from: m () void
    public void drawLevel() {
        this.uiGraphics = this.uiImage.getGraphics();
        this.uiGraphics.setColor(Color.black);
        this.uiGraphics.fillRect(0, 0, 644, 400);

        for(int blockX = 39; blockX >= 0; --blockX) {
            for(int blockY = 20; blockY >= 0; --blockY) {
                char curBlock = this.curLevelBlocks[blockX][blockY];
                if (curBlock != 0) {
                    this.uiGraphics.drawImage(this.blockPictures[curBlock], blockX * 16, blockY * 16, this);
                }

                // Set walkBlockCollisionType. There are 4 types: 0, 1, 2, -1.
                // 0: doesn't block wind, doesn't block fleas, doesn't block block placement
                // 1: is special solid block?
                // 2: solid block
                // -1: fleas walk in but you can't place blocks there
                for(int x = 0; x < 4; ++x) {
                    for(int y = 0; y < 4; ++y) {
                        // Blank space
                        if (curBlock == 0) {
                            this.walkBlockCollisionType[blockX * 4 + x][blockY * 4 + y] = 0;

                        // Flea entrance
                        } else if (curBlock == 1) {
                            this.walkBlockCollisionType[blockX * 4 + x][blockY * 4 + y] = 1;

                        // Ramp (thick) /
                        } else if (curBlock == 3) {
                            if (x == 3 - y) {
                                this.walkBlockCollisionType[blockX * 4 + x][blockY * 4 + y] = 1;
                            } else {
                                this.walkBlockCollisionType[blockX * 4 + x][blockY * 4 + y] = 0;
                            }

                        // Ramp (thin) \
                        } else if (curBlock == 4) {
                            if (x == y) {
                                this.walkBlockCollisionType[blockX * 4 + x][blockY * 4 + y] = 1;
                            } else {
                                this.walkBlockCollisionType[blockX * 4 + x][blockY * 4 + y] = 0;
                            }

                        // Spinning block (horizontal)
                        } else if (curBlock == 8) {
                            this.walkBlockCollisionType[blockX * 4 + x][blockY * 4 + y] = -1;

                        // Recessed Wall
                        } else if (curBlock == 18) {
                            this.walkBlockCollisionType[blockX * 4 + x][blockY * 4 + y] = -1;

                        // Landing pad
                        } else if (curBlock == 11) {
                            if (y == 3) {
                                this.walkBlockCollisionType[blockX * 4 + x][blockY * 4 + y] = 1;
                            } else {
                                this.walkBlockCollisionType[blockX * 4 + x][blockY * 4 + y] = 0;
                            }

                        // other blocks are treated as solid
                        } else {
                            this.walkBlockCollisionType[blockX * 4 + x][blockY * 4 + y] = 2;
                        }
                    }
                }
            }
        }

        this.uiGraphics.drawImage(this.blockPictures[2], 117 + this.gamePadding, 360, this);
        this.uiGraphics.drawImage(this.blockPictures[3], 235 + this.gamePadding, 360, this);
        this.uiGraphics.drawImage(this.blockPictures[4], 352 + this.gamePadding, 360, this);
        this.highlightSelectedTool(114 + this.gamePadding, 357);
        this.selectedTool = 1;
        this.uiGraphics.setFont(this.helvetica13_);
        this.uiGraphics.setColor(Color.white);
        this.uiGraphics.drawString("Password: " + this.levelPasswords[this.levelIndex], 10, 357);
        this.uiGraphics.drawString("Fleas: " + String.valueOf(this.levelFleaPopulation[this.levelIndex]), 10, 371);
        this.uiGraphics.drawString("Rescue: " + String.valueOf(this.levelFleasToRescue[this.levelIndex]), 10, 385);
    }
}
