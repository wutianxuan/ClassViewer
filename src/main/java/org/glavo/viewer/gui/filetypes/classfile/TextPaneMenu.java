package org.glavo.viewer.gui.filetypes.classfile;

import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import org.glavo.viewer.util.FontUtils;
import org.glavo.viewer.util.ImageUtils;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class TextPaneMenu extends ContextMenu {
    private TextArea textArea;

    public TextPaneMenu(TextArea textArea) {
        this.textArea = textArea;
        MenuItem copy = new MenuItem("_Copy");
        this.setStyle(FontUtils.setUIFont(this.getStyle()));
        copy.setMnemonicParsing(true);
        copy.setOnAction(e -> {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

            StringSelection s = new StringSelection(
                    textArea.getSelectedText()
            );

            clipboard.setContents(s, null);
        });
        copy.setGraphic(new ImageView(ImageUtils.copyImage));

        getItems().addAll(copy);
    }


}
