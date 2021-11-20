import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.time.Duration;
import java.time.Instant;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Main extends JFrame {
    
  class App extends JPanel implements MouseListener {
    Grid grid;
    boolean stageBuilt = false;

    public App() {
        setPreferredSize(new Dimension(400, 400));
        this.addMouseListener(this);
        grid = new Grid();
    }

    @Override
    public void paint(Graphics g) {
        grid.paint(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
  }

  public static void main(String[] args) throws Exception {

    Main window = new Main();
    window.run();

  }

  private Main() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    App canvas = new App();
    this.setContentPane(canvas);
    this.pack();
    this.setVisible(true);
  }

  public void run() {
    while (true) {
      Instant startTime = Instant.now();
      this.repaint();
      Instant endTime = Instant.now();
      long howLong = Duration.between(startTime, endTime).toMillis();
      try {
        Thread.sleep(500L - howLong);
      } catch (InterruptedException e) {
        System.out.println("thread was interrupted, but who cares?");
      }
    }
  }
}