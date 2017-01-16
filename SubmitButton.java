//creates a submit button for any panels that need it so appropriate data can be processed

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SubmitButton extends JButton {
   //parameter for constructor ensures that the submitButton goes to the correct panel
   public SubmitButton(JPanel panel) {
      super("SUBMIT");
      
      GridBagConstraints submitButtonDesign = new GridBagConstraints();
      submitButtonDesign.gridx = 0;
      submitButtonDesign.gridy = 7;
      submitButtonDesign.gridwidth = 2;
      submitButtonDesign.gridheight = 1;   
      
      panel.add(this, submitButtonDesign);
   }
}