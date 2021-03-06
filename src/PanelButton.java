import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelButton extends JPanel{
    private ImagePanel imagePanel;
    private final JButton buttonStartStop = new JButton();
    private final JButton buttonReset = new JButton();
    private SliderText[][] slidersTexts;

    private ActionListener startStop = new ActionListener() {
        private boolean pulsing = false;
        @Override
        public void actionPerformed(ActionEvent e) {
            if (pulsing) {
                pulsing = false;
                imagePanel.stop();
                buttonStartStop.setText("Start");
            } else {
                pulsing = true;
                imagePanel.start();
                buttonStartStop.setText("Stop");
            }
        }
    };


    private ActionListener reset = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (SliderText[] sliderTexts : slidersTexts) {
                for (SliderText sliderText : sliderTexts) {
                    sliderText.resetValue();
                }
            }
            imagePanel.getWasher().toggleUpdate(false);
            CrashSystem.getInstance().update(imagePanel.getRk4List(), imagePanel.getWasher());
            if (imagePanel.getRk4List().size() > 1)
                imagePanel.getRk4List().remove(1);
            imagePanel.getRk4List().get(0).setT(0);
            imagePanel.update();
        }
    };

    public PanelButton(final ImagePanel imagePanel, SliderText[] ... slidersTexts) {
        this.imagePanel = imagePanel;
        this.slidersTexts = slidersTexts;
        GridLayout gl = new GridLayout(3, 1);
        gl.setVgap(10);
        this.setLayout(gl);

        buttonStartStop.setText("Start");
        buttonStartStop.setPreferredSize(new Dimension(70, 26));
        buttonStartStop.addActionListener(startStop);
        this.add(buttonStartStop);

        buttonReset.setText("Reset");
        buttonReset.setPreferredSize(new Dimension(70, 26));
        buttonReset.addActionListener(reset);
        this.add(buttonReset);
    }
}
