package Interface;

import Refreshable.BoardEntity;
import Refreshable.Eye;

import javax.swing.*;
import java.awt.*;
import java.util.Set;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainFrame extends JFrame {
    private final static int WINDOW_SIZE = 900;
    private final JPanel centerPanel = new JPanel();
    private final Set<BoardEntity> entities = Stream.generate(() -> new Eye(WINDOW_SIZE, WINDOW_SIZE)).limit(15).collect(Collectors.toSet());
    public MainFrame() {
        super("Hello world!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WINDOW_SIZE, WINDOW_SIZE);
        this.setResizable(false);
        this.setVisible(true);
        this.add(this.centerPanel);
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

        var e = executor.scheduleAtFixedRate(() -> {
            entities.forEach(BoardEntity::refresh);
            this.centerPanel.repaint();
        }, 0, 10, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("asd");
        entities.forEach(entity -> entity.paint(g));
    }
}
