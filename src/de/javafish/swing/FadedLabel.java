package de.javafish.swing;

import java.awt.*;
import javax.swing.*;

public class FadedLabel extends JLabel {
    private static final long serialVersionUID = 1L;

    // Properties
    private boolean autoFading;
    private int showDuration;
    private int fadeDuration;
    //
    // Attributes
    private boolean fading;
    private Color saveColor;
    //
    // Propertiy initialization
    {
        setAutoFading(false);
        setShowDuration(5000);
        setFadeDuration(2000);
    }
    
    public FadedLabel() {
    }

    public FadedLabel(String text) {
        super(text);
    }

    public FadedLabel(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
    }

    @Override
    public void setText(String text) {
        super.setText(text);
        if (autoFading && !fading) {
            startFading(showDuration);
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
            new Thread(new Fader(showDuration)).start();
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
     * @return the autoFading
     */
    public boolean isAutoFading() {
        return autoFading;
    }

    /**
     * @param autoFading the autoFading to set
     */
    public void setAutoFading(boolean autoFading) {
        this.autoFading = autoFading;
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
    
    
    private class Fader implements Runnable {

        private final int showDuration;

        public Fader(int showDuration) {
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
                setForeground(new Color(
                        saveColor.getRed(),
                        saveColor.getGreen(), 
                        saveColor.getBlue(), 
                        alpha--));
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
