package gui;

public class OverlayOlahraga{
    MyOverlay frame;

    public OverlayOlahraga(){
        frame = new MyOverlay("Your sim is exercising", "olahraga.png");
        frame.setVisible(true);
    }
}