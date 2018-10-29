package views;

import jexer.*;
import jexer.bits.CellAttributes;
import jexer.bits.GraphicsChars;
import jexer.event.TKeypressEvent;
import jexer.event.TMouseEvent;
import static jexer.TKeypress.*;
public class MediaRadioButton extends TRadioButton
{
    /**
     * Label for this radio button.
     */
    private String label;

    public MediaRadioButton(final TRadioGroup parent, final int x, final int y,
        final String label, final int id)
    {
        super(parent,x,y,label,id);
        this.label = label;
    }  
    
    /**
     * Get label for this radio button.  
     *
     * @return the Label
     */
    public String getLabel() {
        return label;
    }
    /**
     * Handle mouse button presses.
     *
     * @param mouse mouse button press event
     */
    @Override
    public void onMouseDown(final TMouseEvent mouse) {
        super.onMouseDown(mouse);
        if (isSelected())
            getApplication().messageBox("what","again",TMessageBox.Type.OK);
    }

    /**
     * Handle keystrokes.
     *
     * @param keypress keystroke event
     */
    @Override
    public void onKeypress(final TKeypressEvent keypress) {
        super.onKeypress(keypress);
        if (isSelected())
            getApplication().messageBox("what","again",TMessageBox.Type.OK);
    }
}