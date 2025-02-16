package ElBob;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Random;
import javax.sound.sampled.*;
import java.io.File;

public class ElBob {
    private static JLabel bob;
    private static Clip currentClip;
    private static ImageIcon normalImage = new ImageIcon("images/lindu.png");
    private static ImageIcon relaxImage = new ImageIcon("images/relaxe.png");
    private static ImageIcon sitImage = new ImageIcon("images/sentado.png");
    private static ImageIcon phoneImage = new ImageIcon("images/cell.png");

    public static void main(String[] args) {
        playAudio("audios/hello.wav");

        JFrame frame = new JFrame("El Bob");
        ImageIcon icon = new ImageIcon("images/logo.png");
        ImageIcon bobr = new ImageIcon("images/lindu.png");
        ImageIcon talkr = new ImageIcon("images/lindu2.png");

        bob = new JLabel(new ImageIcon(bobr.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));

        bob.setIcon(new ImageIcon(talkr.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));

        frame.setUndecorated(true);
        frame.setBackground(new Color(0, 0, 0, 0));

        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.add(bob);
        frame.setContentPane(panel);

        frame.setSize(150, 150);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setAlwaysOnTop(true);
        frame.setIconImage(icon.getImage());

        final Point point = new Point();

        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                point.x = e.getX();
                point.y = e.getY();

                if (SwingUtilities.isRightMouseButton(e)) {
                    JPopupMenu menu = new JPopupMenu();

                    JMenuItem item1 = new JMenuItem("Abrir o Terminal");
                    JMenuItem item2 = new JMenuItem("Abrir o GitHub");
                    JMenuItem item3 = new JMenuItem("Piadas");
                    JMenuItem item4 = new JMenuItem("Ajuda");
                    JMenuItem item5 = new JMenuItem("Informações");
                    JMenuItem item6 = new JMenuItem("Criar site");
                    JMenuItem item7 = new JMenuItem("Info Bob");
                    JMenuItem item8 = new JMenuItem("Declarar");
                    JMenuItem item9 = new JMenuItem("Aperta aqui!");
                    JMenuItem item10 = new JMenuItem("Comandos diretos");
                    JMenuItem item11 = new JMenuItem("Rodar C++");
                    JMenuItem item12 = new JMenuItem("Rodar Python");
                    JMenuItem item13 = new JMenuItem("Rodar Java");
                    JMenuItem item14 = new JMenuItem("Relaxar");
                    JMenuItem item15 = new JMenuItem("Normal");
                    JMenuItem item16 = new JMenuItem("Celular");
                    JMenuItem item17 = new JMenuItem("Sentar");

                    item1.addActionListener(_ -> {
                        try {
                            ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "start");
                            processBuilder.inheritIO();
                            processBuilder.start();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    });
                    item2.addActionListener(_ -> {
                        try {
                            Desktop.getDesktop().browse(new java.net.URI("https://github.com/"));
                        } catch (IOException | java.net.URISyntaxException e1) {
                            e1.printStackTrace();
                        }
                    });
                    item3.addActionListener(_ -> {
                        String[] piadas = {
                                "Por que os químicos são ótimos em resolver problemas?\nPorque eles têm todas as soluções!",
                                "Por que o desenvolvedor faliu?\nPorque ele usou todo o seu cache.",
                                "Minha memória ficou tão ruim que realmente me fez perder o emprego.\nAinda estou empregado. Só não consigo lembrar onde.",
                                "Por que o médico está sempre calmo?\nPorque ele tem muitos pacientes.",
                                "Qual é a comida favorita de um lobisomem?\nNão sei, os Lobisomens não são reais.",
                                "Por que o livro de matemática parece tão triste?\nPor causa de todos os seus problemas.",
                                "O que ganha o melhor dentista do mundo?\n Uma pequena placa."
                        };

                        Random rand = new Random();
                        int index = rand.nextInt(piadas.length);
                        JOptionPane.showMessageDialog(null, piadas[index]);
                    });
                    item4.addActionListener(_ -> {
                        JOptionPane.showMessageDialog(null,
                                "Olá!\nIsso é uma guia rapida mesmo.\nEu só abro aplicativos/sites, crio sites, compila codigos (python, c++, java), etc.",
                                "Guia", JOptionPane.INFORMATION_MESSAGE);
                    });
                    item5.addActionListener(_ -> {
                        playAudio("audios/info.wav");
                        bob.setIcon(new ImageIcon(talkr.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));

                        JOptionPane.showMessageDialog(null,
                                "Olá, eu sou o Bob, e eu posso tentar ajudar você, como por exemplo, abrir o terminal, abrir o github, entre outras coisas",
                                "Info", JOptionPane.INFORMATION_MESSAGE);
                    });
                    item6.addActionListener(_ -> {
                        try {
                            ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "start conf/website.exe");
                            processBuilder.inheritIO();
                            processBuilder.start();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    });
                    item7.addActionListener(_ -> {
                        playAudio("audios/senha.wav");
                        bob.setIcon(new ImageIcon(talkr.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
                        String senha = JOptionPane.showInputDialog(null, "Digite a senha:");

                        if ("elbob".equals(senha)) {
                            playAudio("audios/correct.wav");
                            bob.setIcon(
                                    new ImageIcon(talkr.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));

                            try {
                                ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "start conf/love.exe");
                                processBuilder.inheritIO();
                                processBuilder.start();

                                playAudio("audios/love.wav");
                                bob.setIcon(new ImageIcon(
                                        talkr.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            playAudio("audios/incorrect.wav");
                            bob.setIcon(
                                    new ImageIcon(talkr.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
                        }
                    });
                    item8.addActionListener(_ -> {
                        playAudio("audios/iloveyoutoo.wav");
                        bob.setIcon(new ImageIcon(talkr.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));

                        new SwingWorker<Void, Void>() {
                            @Override
                            protected Void doInBackground() throws Exception {
                                Thread.sleep(1000);
                                return null;
                            }

                            @Override
                            protected void done() {
                                playAudio("audios/mememusic.wav");
                            }
                        }.execute();
                    });
                    item9.addActionListener(_ -> {
                        playAudio("audios/eors2.wav");
                        bob.setIcon(new ImageIcon(talkr.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));

                        new SwingWorker<Void, Void>() {
                            @Override
                            protected Void doInBackground() throws Exception {
                                Thread.sleep(1000);
                                return null;
                            }

                            @Override
                            protected void done() {
                                playAudio("audios/eors.wav");
                            }
                        }.execute();
                    });
                    item10.addActionListener(_ -> {
                        try {
                            ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "start conf/comandos.exe");
                            processBuilder.inheritIO();
                            processBuilder.start();

                            playAudio("audios/system.wav");
                            bob.setIcon(
                                    new ImageIcon(talkr.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    });
                    item11.addActionListener(_ -> {
                        try {
                            ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c",
                                    "start conf/leng/cppCOM.exe");
                            processBuilder.inheritIO();
                            processBuilder.start();

                            playAudio("audios/scompilation.wav");
                            bob.setIcon(
                                    new ImageIcon(talkr.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    });
                    item12.addActionListener(_ -> {
                        try {
                            ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c",
                                    "start conf/leng/pythonCOM.exe");
                            processBuilder.inheritIO();
                            processBuilder.start();

                            playAudio("audios/scompilation.wav");
                            bob.setIcon(
                                    new ImageIcon(talkr.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    });
                    item13.addActionListener(_ -> {
                        try {
                            ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c",
                                    "start conf/leng/javaCOM.exe");
                            processBuilder.inheritIO();
                            processBuilder.start();

                            playAudio("audios/scompilation.wav");
                            bob.setIcon(
                                    new ImageIcon(talkr.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    });
                    item14.addActionListener(_ -> {
                        bob.setIcon(
                                new ImageIcon(relaxImage.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
                    });
                    item15.addActionListener(_ -> {
                        bob.setIcon(
                                new ImageIcon(normalImage.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
                    });
                    item16.addActionListener(_ -> {
                        bob.setIcon(
                                new ImageIcon(phoneImage.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
                    });
                    item17.addActionListener(_ -> {
                        bob.setIcon(
                                new ImageIcon(sitImage.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
                    });

                    menu.add(item1);
                    menu.add(item2);
                    menu.add(item3);
                    menu.add(item4);
                    menu.add(item5);
                    menu.add(item6);
                    menu.add(item7);
                    menu.add(item8);
                    menu.add(item9);
                    menu.add(item10);
                    menu.add(item11);
                    menu.add(item12);
                    menu.add(item13);
                    menu.add(item14);
                    menu.add(item16);
                    menu.add(item17);
                    menu.add(item15);

                    menu.show(frame, e.getX(), e.getY());
                }
            }
        });

        frame.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                frame.setLocation(e.getXOnScreen() - point.x, e.getYOnScreen() - point.y);
            }
        });

        frame.setVisible(true);
    }

    public static void playAudio(String fileName) {
        try {
            if (currentClip != null && currentClip.isRunning()) {
                currentClip.stop();
            }

            File audioFile = new File(fileName);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            currentClip = AudioSystem.getClip();
            currentClip.open(audioStream);
            currentClip.start();

            currentClip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    SwingUtilities.invokeLater(() -> {
                        ImageIcon bobr = new ImageIcon("images/lindu.png");
                        bob.setIcon(new ImageIcon(bobr.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
                    });
                }
            });

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}