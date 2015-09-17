package de.javafish.swing;

import java.awt.*;
import javax.swing.*;

public class FadedLabel extends JLabel {
    private static final long serialVersionUID = 1L;

    // Properties
    private boolean autoFadeIn;
    private boolean autoFadeOut;
    private int showDuration;
    private int fadeDuration;
    //
    // Propertiy initialization
    {
        setAutoFadeIn(false);
        setAutoFadeOut(false);
        setShowDuration(5000);
        setFadeDuration(2000);
    }
    //
    // Attributes
    private boolean fading;
    private Color saveColor;
    
    public FadedLabel() {
    }

    public FadedLabel(String text) {
        super(text);
    }

    public FadedLabel(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
    }

    @Override
    public void setForeground(Color c) {
        setColor(c);
        saveColor = c;
    }

    private void setAlpha(int alpha) {
        setColor(new Color(
                saveColor.getRed(), 
                saveColor.getGreen(), 
                saveColor.getBlue(), 
                alpha)
        );
    }
    
    private void setColor(Color c) {
        super.setForeground(c);
    }
    
    @Override
    public void setText(String text) {
        if (autoFadeIn) {
            fadeIn(text);
        } else {
            super.setText(text);
        }
        if (autoFadeOut && !fading) {
            startFading(showDuration);
        }
    }
    
    private void fadeIn(String text) {
        if (fading) {
            
        }
    }
    
    public void fade() {
        if (!fading) {
            startFading(showDuration);
        }
    }
    
    public void fade(boolean direct) {
        if (!fading) {
            if (direct) {
                startFading(0);
            } else {
                startFading(showDuration);
            }
        }
    }
    
    private synchronized void startFading(int showDuration) {
        if (!fading) {
            fading = true;
            saveColor = getForeground();
            new Thread(new FaderOut(showDuration)).start();
        }
    }

    private void endFading() {
        if (fading) {
            super.setText(" ");
            setForeground(saveColor);
            fading = false;
        }
    }

    /**
     * @return the showDuration
     */
    public int getShowDuration() {
        return showDuration;
    }

    /**
     * @param showDuration the showDuration to set
     */
    public void setShowDuration(int showDuration) {
        this.showDuration = showDuration;
    }

    /**
     * @return the fadeDuration
     */
    public int getFadeDuration() {
        return fadeDuration;
    }

    /**
     * @param fadeDuration the fadeDuration to set
     */
    public void setFadeDuration(int fadeDuration) {
        this.fadeDuration = fadeDuration;
    }

    /**
     * @return the autoFadeIn
     */
    public boolean isAutoFadeIn() {
        return autoFadeIn;
    }

    /**
     * @param autoFadeIn the autoFadeIn to set
     */
    public void setAutoFadeIn(boolean autoFadeIn) {
        this.autoFadeIn = autoFadeIn;
    }

    /**
     * @return the autoFadeOut
     */
    public boolean isAutoFadeOut() {
        return autoFadeOut;
    }

    /**
     * @param autoFadeOut the autoFadeOut to set
     */
    public void setAutoFadeOut(boolean autoFadeOut) {
        this.autoFadeOut = autoFadeOut;
    }
    
    
    private class FaderOut implements Runnable {

        private final int showDuration;

        public FaderOut(int showDuration) {
            this.showDuration = showDuration;
        }
        
        @Override
        public void run() {
            try {
                Thread.sleep(showDuration);
            } catch (InterruptedException ex) {
                endFading();
                return;
            }
            int alpha = saveColor.getAlpha();
            int delay = fadeDuration / alpha;
            while (alpha > 0) {
                setAlpha(alpha--);
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                if (Thread.interrupted()) {
                    break;
                }
            }
            endFading();
        }
    }
}
