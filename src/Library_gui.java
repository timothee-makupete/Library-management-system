import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.List;

public class Library_gui {
    private static JButton viewDetailsButton, deleteButton, viewBooksButton, addBookButton, removeBookButton,
            exitButton, changeThemeButton, settingsButton, saveButton, resetButton;
    private static JLabel textLabel, titleError, authorError, ISBNError, publicationYearError, totalCopiesError;
    private static JPanel welcomingPanel, noBooks, savePanel, savePanel2, addBookPanel, viewBookPanel, settingsPanel,
            viewBookPanel2, removeBookPanel, removeBookPanel2, topPanel, leftPanel, minPanel1, centerPanel, minPanel;
    private static JTextField searchField, titleField, authorField, ISBNField, publicationYearField, totalCopiesField;
    private static JLabel titleLabel, authorLabel, ISBNLabel, publicationYearLabel, totalCopiesLabel;
    private static JLabel brandName, text2, text4, checkAllText;
    private static boolean isThemeChanged = false;
    private static java.util.Timer loaderTimer;
    private static int progress;
    private static JLabel displayAuthor, displayISBN, displayTitle, displayTotalCopies, displayPublicationYear;
    private static JFrame mainFrame;
    private static JDialog dialog, dialog2;
    private static JScrollPane scrollPane, scrollPane3;
    private static JCheckBox checkAll, deleteCheckbox;

    private static LineBorder border = new LineBorder(new Color(8, 15, 21), 10);
    private static LineBorder border2 = new LineBorder(new Color(0xA19A9A), 10);
    private static List<JCheckBox> checkboxes = new ArrayList<>();
    private static List<JPanel> minDeletePanels = new ArrayList<>();
    private static List<JPanel> minDeletePanels2 = new ArrayList<>();
    private static List<JLabel> detailLabels = new ArrayList<>();
    private static List<JLabel> detailLabels2 = new ArrayList<>();
    private static ArrayList<Integer> copies = new ArrayList<>();
    private static List<JButton> viewButtons = new ArrayList<>();
    private static Map<JButton, JLabel> checkboxLabelMap2 = new HashMap<>();

    public static void main(String[] args) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(screenWidth, screenHeight);
        ImageIcon icon = new ImageIcon("resources/book1.png");

        mainFrame.setIconImage(icon.getImage());
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.getContentPane().setBackground(new Color(8, 15, 21));
        topPanel = new JPanel();
        topPanel.setLayout(null);
        brandName = new JLabel("LIBRARY MANAGEMENT APPLICATION");
        brandName.setFont(new Font("Arial", Font.BOLD, 17));
        brandName.setBounds(49, 5, 400, 40);
        brandName.setForeground(Color.WHITE);

        welcomingPanel = new JPanel(null);
        welcomingPanel.setBounds(0, 0, screenWidth, screenHeight);
        welcomingPanel.setBackground(new Color(13, 23, 33));
        mainFrame.add(welcomingPanel);

        ImageIcon imageIcon18 = new ImageIcon("resources/lib2a.png");
        JLabel imageLabel18 = new JLabel(imageIcon18);
        imageLabel18.setBounds((screenWidth / 2) - 250, 190, 250, 250);
        welcomingPanel.add(imageLabel18);

        JLabel t1 = new JLabel("LIBRARY");
        t1.setBounds((screenWidth / 2), 265, 300, 30);
        t1.setForeground(new Color(0xfffffff));
        t1.setFont(new Font("cursive", Font.BOLD, 35));
        welcomingPanel.add(t1);
        JLabel t2 = new JLabel("MANAGEMENT");
        t2.setBounds((screenWidth / 2), 305, 300, 30);
        t2.setForeground(new Color(30, 144, 255));
        t2.setFont(new Font("cursive", Font.BOLD, 35));
        welcomingPanel.add(t2);
        JLabel t3 = new JLabel("APPLICATION");
        t3.setBounds((screenWidth / 2), 345, 300, 30);
        t3.setForeground(new Color(0xfffffff));
        t3.setFont(new Font("cursive", Font.BOLD, 35));
        welcomingPanel.add(t3);

        JLabel loadingText = new JLabel("loading...");
        loadingText.setBounds((screenWidth / 2) - 40, 440, 300, 30);
        loadingText.setFont(new Font("Arial", Font.ITALIC, 22));
        loadingText.setForeground(new Color(0xfffffff));
        welcomingPanel.add(loadingText);

        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setBounds((screenWidth / 2) - 250, 420, 530, 20);

        progressBar.setBorder(new LineBorder(new Color(30, 144, 255), 1, true));
        progressBar.setForeground(new Color(30, 144, 255)); // Set the foreground color

        welcomingPanel.add(progressBar);

        loaderTimer = new java.util.Timer();
        loaderTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (progress >= 100) {
                    progressBar.setValue(100);
                    loaderTimer.cancel();
                } else {
                    progress++;
                    progressBar.setValue(progress);
                }
            }
        }, 20, 150);

        topPanel.add(brandName);
        topPanel.setVisible(false);
        topPanel.setBounds(0, 0, screenWidth, 50);
        topPanel.setBackground(new Color(8, 15, 21));

        ImageIcon imageIcon5 = new ImageIcon("resources/book4.png");
        JLabel imageLabel5 = new JLabel(imageIcon5);
        imageLabel5.setBounds(2, 0, 50, 50);
        topPanel.add(imageLabel5);

        ImageIcon imageIcon7 = new ImageIcon("resources/book1.png");
        JLabel imageLabel7 = new JLabel(imageIcon7);
        imageLabel7.setBounds(800, 0, 260, 200);

        ImageIcon imageIcon6 = new ImageIcon("resources/book3.png");
        JLabel imageLabel6 = new JLabel(imageIcon6);
        imageLabel6.setBounds(720, 0, 260, 240);
        topPanel.add(imageLabel6);
        topPanel.add(imageLabel7);

        mainFrame.add(topPanel);

        leftPanel = new JPanel(null);
        leftPanel.setBounds(0, 50, 300, screenHeight);
        leftPanel.setVisible(false);
        leftPanel.setBackground(new Color(8, 15, 21));
        mainFrame.add(leftPanel);

        ImageIcon imageIcon = new ImageIcon("resources/book2.png");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(0, 0, 260, 265);
        leftPanel.add(imageLabel);

        centerPanel = new JPanel();
        centerPanel.setVisible(false);
        centerPanel.setBounds(300, 50, 1500, 1000);
        centerPanel.setLayout(null);
        centerPanel.setBackground(new Color(13, 23, 33));
        mainFrame.add(centerPanel);

        EmptyBorder padding = new EmptyBorder(10, 70, 10, 10);
        EmptyBorder padding2 = new EmptyBorder(10, 50, 10, 10);
        viewBooksButton = new JButton("VIEW BOOKS");
        viewBooksButton.setBounds(5, 255, 285, 45);
        viewBooksButton.setBackground(new Color(13, 23, 33));
        viewBooksButton.setFocusPainted(false);
        viewBooksButton.setBorder(BorderFactory.createEmptyBorder());
        viewBooksButton.setForeground(Color.WHITE);
        viewBooksButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        viewBooksButton.setFont(new Font("Arial", Font.PLAIN, 14));
        viewBooksButton.setHorizontalAlignment(SwingConstants.LEFT);
        viewBooksButton.setBorder(padding);
        viewBooksButton.setLayout(null);
        viewBooksButton.addActionListener(new viewEvent());
        leftPanel.add(viewBooksButton);

        ImageIcon imageIcon8 = new ImageIcon("resources/view2.png");
        JLabel imageLabel8 = new JLabel(imageIcon8);
        imageLabel8.setBounds(2, 1, 60, 50);
        viewBooksButton.add(imageLabel8);

        viewBookPanel = new JPanel(new GridLayout(0, 1));
        viewBookPanel.setBackground(new Color(13, 23, 33));
        viewBookPanel.setBounds(10, 120, screenWidth / 2, screenHeight - 200);
        viewBookPanel.setVisible(true);

        viewBookPanel2 = new JPanel();
        viewBookPanel2.setBackground(new Color(13, 23, 33));
        viewBookPanel2.setLayout(null);
        viewBookPanel2.setVisible(true);
        viewBookPanel2.setBounds((screenWidth / 2) + 30, 120, 330, screenHeight - 200);
        centerPanel.add(viewBookPanel2);

        noBooks = new JPanel();
        noBooks.setLayout(null);
        noBooks.setBounds(0, 0, screenWidth / 2, 400);
        noBooks.setBackground(new Color(13, 23, 33));
        noBooks.setVisible(false);
        JLabel noAvailableBooks = new JLabel("NO BOOKS AVAILABLE...");
        noAvailableBooks.setForeground(Color.WHITE);
        noAvailableBooks.setFont(new Font("Arial", Font.BOLD, 20));
        noAvailableBooks.setBounds(120, 90, 500, 30);
        noBooks.add(noAvailableBooks);

        ImageIcon imageIcon17 = new ImageIcon("resources/notA2.png");
        JLabel imageLabel17 = new JLabel(imageIcon17);
        imageLabel17.setBounds(110, 120, 250, 250);
        noBooks.add(imageLabel17);

        JLabel search = new JLabel("Search here..");
        search.setBounds(10, 5, 200, 20);
        search.setForeground(Color.WHITE);
        search.setFont(new Font("Arial", Font.PLAIN, 17));
        viewBookPanel2.add(search);

        searchField = new JTextField();
        searchField.setBounds(10, 27, 200, 40);
        searchField.setBackground(new Color(8, 15, 21));
        searchField.setForeground(Color.WHITE);
        searchField.setCaretColor(Color.WHITE);
        searchField.setFont(new Font("Arial", Font.PLAIN, 18));
        viewBookPanel2.add(searchField);

        ImageIcon searchIcon = new ImageIcon("resources/search.png");
        JButton searchButton = new JButton(searchIcon);
        searchButton.setBounds(220, 27, 40, 40);
        searchButton.setBackground(new Color(13, 23, 33));
        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        viewBookPanel2.add(searchButton);

        JLabel text1 = new JLabel("AVAILABLE BOOKS");
        text1.setBounds(120, 28, 300, 30);
        text1.setForeground(new Color(30, 144, 255));
        text1.setFont(new Font("Consolas", Font.BOLD, 20));

        JLabel text3 = new JLabel("AVAILABLE TOTAL COPIES");
        text3.setBounds(530, 28, 300, 30);
        text3.setForeground(new Color(30, 144, 255));
        text3.setFont(new Font("Consolas", Font.BOLD, 20));

        text4 = new JLabel("");
        text4.setBounds(590, 60, 300, 40);
        text4.setForeground(new Color(30, 144, 255));
        text4.setFont(new Font("Consolas", Font.BOLD, 40));

        ImageIcon imageIcon1 = new ImageIcon("resources/book1.png");
        JLabel imageLabel1 = new JLabel(imageIcon1);
        imageLabel1.setBounds(250, 20, 260, 265);

        ImageIcon imageIcon3 = new ImageIcon("resources/book3.png");
        JLabel imageLabel3 = new JLabel(imageIcon3);
        imageLabel3.setBounds(320, 0, 260, 265);

        ImageIcon imageIcon2 = new ImageIcon("resources/book1b.png");
        JLabel imageLabel2 = new JLabel(imageIcon2);
        imageLabel2.setBounds(10, 10, 125, 85);

        text2 = new JLabel("");
        text2.setBounds(130, 60, 300, 40);
        text2.setForeground(new Color(30, 144, 255));
        text2.setFont(new Font("Consolas", Font.BOLD, 40));

        minPanel1 = new JPanel();
        minPanel1.setBackground(new Color(8, 15, 21));
        minPanel1.setLayout(null);
        minPanel1.setBounds(10, 10, screenWidth - 315, 100);
        minPanel1.add(text1);
        minPanel1.add(text2);
        minPanel1.add(text3);
        minPanel1.add(text4);
        minPanel1.add(imageLabel1);
        minPanel1.add(imageLabel2);
        minPanel1.add(imageLabel3);
        centerPanel.add(minPanel1);
        loadBooks();
        viewBookDetails();
        scrollPane = new JScrollPane(viewBookPanel);
        scrollPane.setBackground(new Color(13, 23, 33));
        scrollPane.setBounds(10, 120, screenWidth / 2, screenHeight - 200);
        scrollPane.setVisible(true);
        centerPanel.add(scrollPane);

        addBookButton = new JButton("ADD BOOK");
        addBookButton.setBounds(5, 305, 285, 45);
        addBookButton.setBackground(new Color(13, 23, 33));
        addBookButton.setFocusPainted(false);
        addBookButton.setBorder(BorderFactory.createEmptyBorder());
        addBookButton.setForeground(Color.WHITE);
        addBookButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addBookButton.setLayout(null);
        addBookButton.setFont(new Font("Arial", Font.PLAIN, 14));
        addBookButton.setHorizontalAlignment(SwingConstants.LEFT);
        addBookButton.setBorder(padding);
        addBookButton.addActionListener(new addBookEvent());
        leftPanel.add(addBookButton);

        ImageIcon imageIcon9 = new ImageIcon("resources/add.png");
        JLabel imageLabel9 = new JLabel(imageIcon9);
        imageLabel9.setBounds(2, 1, 60, 50);
        addBookButton.add(imageLabel9);

        addBookPanel = new JPanel();
        addBookPanel.setBounds(0, 0, 1500, screenHeight);
        addBookPanel.setBackground(new Color(13, 23, 33));
        addBookPanel.setVisible(false);
        addBookPanel.setLayout(null);
        centerPanel.add(addBookPanel);

        removeBookButton = new JButton("REMOVE BOOK");
        removeBookButton.setFont(new Font("Arial", Font.PLAIN, 14));
        removeBookButton.setBounds(5, 355, 285, 45);
        removeBookButton.setBackground(new Color(13, 23, 33));
        removeBookButton.setFocusPainted(false);
        removeBookButton.setBorder(BorderFactory.createEmptyBorder());
        removeBookButton.setForeground(Color.WHITE);
        removeBookButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        removeBookButton.setHorizontalAlignment(SwingConstants.LEFT);
        removeBookButton.setBorder(padding);
        removeBookButton.setLayout(null);
        removeBookButton.addActionListener(new removeBookEvent());
        leftPanel.add(removeBookButton);

        ImageIcon imageIcon10 = new ImageIcon("resources/remove.png");
        JLabel imageLabel10 = new JLabel(imageIcon10);
        imageLabel10.setBounds(2, 0, 60, 50);
        removeBookButton.add(imageLabel10);

        removeBookPanel = new JPanel(new GridLayout(0, 2));
        removeBookPanel.setBounds(0, 0, screenWidth, screenHeight);
        removeBookPanel.setBackground(new Color(13, 23, 33));
        removeBookPanel.setVisible(false);
        centerPanel.add(removeBookPanel);
        refreshDeletePanel();
        scrollPane3 = new JScrollPane(removeBookPanel);
        scrollPane3.setBackground(new Color(13, 23, 33));
        scrollPane3.setBounds(10, 120, screenWidth / 2, screenHeight - 200);

        scrollPane3.setVisible(true);
        centerPanel.add(scrollPane3);

        removeBookPanel2 = new JPanel();
        removeBookPanel2.setBackground(new Color(8, 15, 21));
        removeBookPanel2.setLayout(null);
        removeBookPanel2.setVisible(false);
        removeBookPanel2.setBounds(screenWidth / 2 + 30, 120, 320, screenHeight - 200);
        centerPanel.add(removeBookPanel2);

        deleteButton = new JButton("DELETE SELECTED");
        deleteButton.setBounds(10, 80, 200, 35);
        deleteButton.setBackground(new Color(30, 144, 255));
        deleteButton.setFocusPainted(false);
        deleteButton.setBorder(BorderFactory.createEmptyBorder());
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        deleteButton.setHorizontalAlignment(SwingConstants.LEFT);
        deleteButton.setBorder(padding2);

        removeBookPanel2.add(deleteButton);
        checkAllText = new JLabel("Select all Books");
        checkAllText.setBounds(30, 35, 300, 30);
        checkAllText.setForeground(Color.WHITE);
        checkAllText.setFont(new Font("Arial", Font.PLAIN, 16));
        checkAll = new JCheckBox();
        checkAll.setBounds(5, 40, 20, 20);
        checkAll.setBackground(new Color(13, 23, 33));
        checkAll.addActionListener(new checksAll());
        removeBookPanel2.add(checkAll);
        removeBookPanel2.add(checkAllText);

        changeThemeButton = new JButton("CHANGE THEME");
        changeThemeButton.setBounds(5, 405, 285, 45);
        changeThemeButton.setBackground(new Color(13, 23, 33));
        changeThemeButton.setFocusPainted(false);
        changeThemeButton.setBorder(BorderFactory.createEmptyBorder());
        changeThemeButton.setForeground(Color.WHITE);
        changeThemeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        changeThemeButton.setHorizontalAlignment(SwingConstants.LEFT);
        changeThemeButton.setBorder(padding);
        changeThemeButton.setFont(new Font("Arial", Font.PLAIN, 14));
        changeThemeButton.setLayout(null);
        changeThemeButton.addActionListener(new changeThemeEvent());
        leftPanel.add(changeThemeButton);

        ImageIcon imageIcon11 = new ImageIcon("resources/theme.png");
        JLabel imageLabel11 = new JLabel(imageIcon11);
        imageLabel11.setBounds(2, 0, 60, 50);
        changeThemeButton.add(imageLabel11);

        settingsButton = new JButton("SETTINGS");
        settingsButton.setFont(new Font("Arial", Font.PLAIN, 14));
        settingsButton.setBounds(5, 455, 285, 45);
        settingsButton.setBackground(new Color(13, 23, 33));
        settingsButton.setFocusPainted(false);
        settingsButton.setBorder(BorderFactory.createEmptyBorder());
        settingsButton.setForeground(Color.WHITE);
        settingsButton.setLayout(null);
        settingsButton.setHorizontalAlignment(SwingConstants.LEFT);
        settingsButton.setBorder(padding);
        settingsButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        settingsButton.addActionListener(new settingsEvent());
        leftPanel.add(settingsButton);

        ImageIcon imageIcon12 = new ImageIcon("resources/settings.png");
        JLabel imageLabel12 = new JLabel(imageIcon12);
        imageLabel12.setBounds(2, 0, 60, 50);
        settingsButton.add(imageLabel12);

        settingsPanel = new JPanel();
        settingsPanel.setBounds(0, 0, 1500, 1000);
        settingsPanel.setBackground(new Color(13, 23, 33));
        settingsPanel.setVisible(false);
        centerPanel.add(settingsPanel);

        exitButton = new JButton("EXIT");
        exitButton.setFont(new Font("Arial", Font.PLAIN, 14));
        exitButton.setBounds(5, 505, 285, 45);
        exitButton.setBackground(new Color(13, 23, 33));
        exitButton.setFocusPainted(false);
        exitButton.setBorder(BorderFactory.createEmptyBorder());
        exitButton.setForeground(Color.WHITE);
        exitButton.setHorizontalAlignment(SwingConstants.LEFT);
        exitButton.setBorder(padding);
        exitButton.setLayout(null);
        exitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        exitButton.addActionListener(new exitEvent());
        leftPanel.add(exitButton);

        ImageIcon imageIcon13 = new ImageIcon("resources/exit.png");
        JLabel imageLabel13 = new JLabel(imageIcon13);
        imageLabel13.setBounds(2, 0, 60, 50);
        exitButton.add(imageLabel13);

        titleLabel = new JLabel("ENTER TITLE");
        titleLabel.setBounds(150, 200, 300, 33);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        addBookPanel.add(titleLabel);

        titleField = new JTextField();
        titleField.setBounds(150, 230, 250, 33);
        titleField.setBackground(new Color(13, 23, 35));
        titleField.setForeground(Color.WHITE);
        titleField.setCaretColor(Color.WHITE);
        titleField.setFont(new Font("Arial", Font.PLAIN, 18));
        addBookPanel.add(titleField);

        authorLabel = new JLabel("ENTER AUTHOR NAME");
        authorLabel.setBounds(450, 200, 300, 33);
        authorLabel.setForeground(Color.WHITE);
        authorLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        addBookPanel.add(authorLabel);

        authorField = new JTextField();
        authorField.setBounds(450, 230, 250, 33);
        authorField.setBackground(new Color(13, 23, 35));
        authorField.setForeground(Color.WHITE);
        authorField.setCaretColor(Color.WHITE);
        authorField.setFont(new Font("Arial", Font.PLAIN, 18));
        addBookPanel.add(authorField);

        ISBNLabel = new JLabel("ENTER ISBN");
        ISBNLabel.setBounds(150, 300, 300, 33);
        ISBNLabel.setForeground(Color.WHITE);
        ISBNLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        addBookPanel.add(ISBNLabel);

        ISBNField = new JTextField();
        ISBNField.setBounds(150, 330, 250, 33);
        ISBNField.setBackground(new Color(13, 23, 35));
        ISBNField.setForeground(Color.WHITE);
        ISBNField.setCaretColor(Color.WHITE);
        ISBNField.setFont(new Font("Arial", Font.PLAIN, 18));
        addBookPanel.add(ISBNField);

        publicationYearLabel = new JLabel("ENTER PUBLICATION YEAR");
        publicationYearLabel.setBounds(450, 300, 300, 33);
        publicationYearLabel.setForeground(Color.WHITE);
        publicationYearLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        addBookPanel.add(publicationYearLabel);

        publicationYearField = new JTextField();
        publicationYearField.setBounds(450, 330, 250, 33);
        publicationYearField.setBackground(new Color(13, 23, 35));
        publicationYearField.setForeground(Color.WHITE);
        publicationYearField.setCaretColor(Color.WHITE);
        publicationYearField.setFont(new Font("Arial", Font.PLAIN, 18));
        addBookPanel.add(publicationYearField);

        totalCopiesLabel = new JLabel("ENTER TOTAL COPIES");
        totalCopiesLabel.setBounds(150, 390, 300, 33);
        totalCopiesLabel.setForeground(Color.WHITE);
        totalCopiesLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        addBookPanel.add(totalCopiesLabel);

        totalCopiesField = new JTextField();
        totalCopiesField.setBounds(150, 420, 550, 33);
        totalCopiesField.setBackground(new Color(13, 23, 35));
        totalCopiesField.setForeground(Color.WHITE);
        totalCopiesField.setCaretColor(Color.WHITE);
        totalCopiesField.setFont(new Font("Arial", Font.PLAIN, 18));
        addBookPanel.add(totalCopiesField);

        saveButton = new JButton("SAVE");
        saveButton.setBounds(150, 490, 250, 40);
        saveButton.setBackground(new Color(30, 144, 255));
        saveButton.setFocusPainted(false);
        saveButton.setFont(new Font("Arial", Font.PLAIN, 15));
        saveButton.setBorder(BorderFactory.createEmptyBorder());
        saveButton.setForeground(Color.WHITE);
        saveButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        saveButton.addActionListener(new saveEvent());
        addBookPanel.add(saveButton);

        resetButton = new JButton("RESET");
        resetButton.setBounds(450, 490, 250, 40);
        resetButton.setBackground(new Color(30, 144, 255));
        resetButton.setFocusPainted(false);
        resetButton.setFont(new Font("Arial", Font.PLAIN, 15));
        resetButton.setBorder(BorderFactory.createEmptyBorder());
        resetButton.setForeground(Color.WHITE);
        resetButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        resetButton.addActionListener(new resetEvent());
        addBookPanel.add(resetButton);

        titleError = new JLabel("");
        titleError.setBounds(155, 260, 250, 30);
        titleError.setForeground(Color.RED);
        titleError.setFont(new Font("Arial", Font.ITALIC, 15));
        addBookPanel.add(titleError);

        authorError = new JLabel("");
        authorError.setBounds(460, 260, 250, 30);
        authorError.setForeground(Color.RED);
        authorError.setFont(new Font("Arial", Font.ITALIC, 15));
        addBookPanel.add(authorError);

        ISBNError = new JLabel("");
        ISBNError.setBounds(155, 360, 250, 30);
        ISBNError.setForeground(Color.RED);
        ISBNError.setFont(new Font("Arial", Font.ITALIC, 15));
        addBookPanel.add(ISBNError);

        publicationYearError = new JLabel("");
        publicationYearError.setBounds(460, 360, 250, 30);
        publicationYearError.setForeground(Color.RED);
        publicationYearError.setFont(new Font("Arial", Font.ITALIC, 15));
        addBookPanel.add(publicationYearError);

        totalCopiesError = new JLabel("");
        totalCopiesError.setBounds(155, 450, 250, 30);
        totalCopiesError.setForeground(Color.RED);
        totalCopiesError.setFont(new Font("Arial", Font.ITALIC, 15));
        addBookPanel.add(totalCopiesError);

        dialog = new JDialog(mainFrame, "", true);
        dialog.setSize(400, 350);
        dialog.setLocationRelativeTo(mainFrame);

        // Add content to the dialog
        savePanel = new JPanel();
        savePanel.setLayout(null);
        savePanel.setBounds(0, 0, 400, 350);
        savePanel.setBackground(new Color(13, 23, 35));

        ImageIcon imageIcon16 = new ImageIcon("resources/checked_1.png");
        JLabel imageLabel16 = new JLabel(imageIcon16);
        imageLabel16.setBounds(150, 40, 100, 100);
        savePanel.add(imageLabel16);

        textLabel = new JLabel("SAVED");
        textLabel.setBounds(150, 160, 200, 30);
        textLabel.setForeground(new Color(0xffffff));
        textLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        savePanel.add(textLabel);

        dialog.getContentPane().add(savePanel);
        dialog.setResizable(false);
        dialog.setVisible(false);

        dialog2 = new JDialog(mainFrame, "book details", true);
        dialog2.setSize(500, 320);
        dialog2.setLocationRelativeTo(mainFrame);

        // Add content to the dialog
        savePanel2 = new JPanel();
        savePanel2.setLayout(null);
        savePanel2.setBounds(0, 0, 500, 320);
        savePanel2.setBackground(new Color(0x12345));

        ImageIcon imageIcon20 = new ImageIcon("resources/lib4a.png");
        JLabel imageLabel20 = new JLabel(imageIcon20);
        imageLabel20.setBounds(160, 8, 100, 100);
        savePanel2.add(imageLabel20);

        JLabel displayTitleText = new JLabel("TITLE");
        displayTitleText.setForeground(new Color(0xffffff));
        displayTitleText.setFont(new Font("Arial", Font.BOLD, 15));
        displayTitleText.setBounds(10, 120, 200, 20);

        displayTitle = new JLabel("N/A");
        displayTitle.setForeground(new Color(0xffffff));
        displayTitle.setFont(new Font("Arial", Font.PLAIN, 15));
        displayTitle.setBounds(240, 120, 200, 20);

        JLabel displayAuthorText = new JLabel("AUTHOR");
        displayAuthorText.setForeground(new Color(0xffffff));
        displayAuthorText.setFont(new Font("Arial", Font.BOLD, 13));
        displayAuthorText.setBounds(10, 150, 200, 20);

        displayAuthor = new JLabel("N/A");
        displayAuthor.setForeground(new Color(0xffffff));
        displayAuthor.setFont(new Font("Arial", Font.PLAIN, 14));
        displayAuthor.setBounds(240, 150, 200, 20);

        JLabel displayISBNtext = new JLabel("ISBN");
        displayISBNtext.setForeground(new Color(0xffffff));
        displayISBNtext.setFont(new Font("Arial", Font.BOLD, 13));
        displayISBNtext.setBounds(10, 180, 200, 20);

        displayISBN = new JLabel("N/A");
        displayISBN.setForeground(new Color(0xffffff));
        displayISBN.setFont(new Font("Arial", Font.PLAIN, 14));
        displayISBN.setBounds(240, 180, 200, 20);

        JLabel displayPublicationYearText = new JLabel("PUBLICATION YEAR");
        displayPublicationYearText.setForeground(new Color(0xffffff));
        displayPublicationYearText.setFont(new Font("Arial", Font.BOLD, 13));
        displayPublicationYearText.setBounds(10, 210, 200, 20);

        displayPublicationYear = new JLabel("N/A");
        displayPublicationYear.setForeground(new Color(0xffffff));
        displayPublicationYear.setFont(new Font("Arial", Font.PLAIN, 14));
        displayPublicationYear.setBounds(240, 210, 200, 20);

        JLabel displayTotalCopiesText = new JLabel("TOTAL COPIES");
        displayTotalCopiesText.setForeground(new Color(0xffffff));
        displayTotalCopiesText.setFont(new Font("Arial", Font.BOLD, 13));
        displayTotalCopiesText.setBounds(10, 240, 200, 20);

        displayTotalCopies = new JLabel("N/A");
        displayTotalCopies.setForeground(new Color(0xffffff));
        displayTotalCopies.setFont(new Font("Arial", Font.PLAIN, 14));
        displayTotalCopies.setBounds(240, 240, 200, 20);

        savePanel2.add(displayTitleText);
        savePanel2.add(displayTitle);
        savePanel2.add(displayAuthorText);
        savePanel2.add(displayAuthor);
        savePanel2.add(displayISBNtext);
        savePanel2.add(displayISBN);
        savePanel2.add(displayPublicationYearText);
        savePanel2.add(displayPublicationYear);
        savePanel2.add(displayTotalCopiesText);
        savePanel2.add(displayTotalCopies);

        dialog2.getContentPane().add(savePanel2);
        dialog2.setResizable(false);
        dialog2.setVisible(false);

        mainFrame.setLayout(null);
        mainFrame.setVisible(true);
        int delayInSeconds = 15;

        try {
            Thread.sleep(delayInSeconds * 1000);
            welcomingPanel.setVisible(false);
            topPanel.setVisible(true);
            leftPanel.setVisible(true);
            centerPanel.setVisible(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Map<JCheckBox, JLabel> checkboxLabelMap = new HashMap<>();
                List<JPanel> panelsToRemove = new ArrayList<>();
                List<String> fileLines = new ArrayList<>();

                try (BufferedReader reader = new BufferedReader(new FileReader("books.txt"))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        fileLines.add(line);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                    return;
                }

                for (int i = 0; i < checkboxes.size(); i++) {
                    JCheckBox box = checkboxes.get(i);
                    JPanel pan = minDeletePanels.get(i);

                    JLabel finalLabel = null;
                    for (Component component : pan.getComponents()) {
                        if (component instanceof JLabel) {
                            finalLabel = (JLabel) component;
                            break;
                        }
                    }

                    JLabel label = finalLabel;
                    if (label != null) {
                        checkboxLabelMap.put(box, label);

                        boolean isSelected = box.isSelected();
                        if (isSelected && checkboxLabelMap.get(box) == label) {
                            String text = label.getText();
                            System.out.println(text);

                            // Check if the text exists in the file and delete matching lines
                            for (int j = 0; j < fileLines.size(); j++) {
                                String line = fileLines.get(j);
                                if (line.contains(text)) {
                                    fileLines.remove(j);
                                    j--; // Decrement the index as the list size has changed
                                }
                            }

                            // Mark the panel for removal
                            panelsToRemove.add(pan);
                        }
                    }
                }

                // Remove the marked panels from their parent container
                for (JPanel panel : panelsToRemove) {
                    Container parent = panel.getParent();
                    if (parent != null) {
                        parent.remove(panel);
                    }
                }

                // Repaint the parent container to update the UI
                SwingUtilities.getWindowAncestor(deleteButton).revalidate();
                SwingUtilities.getWindowAncestor(deleteButton).repaint();

                // Write the modified contents back to the file
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("books.txt"))) {
                    for (String line : fileLines) {
                        writer.write(line);
                        writer.newLine();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                viewBookPanel.removeAll();
                copies.clear();
                viewButtons.clear();
                minDeletePanels2.clear();
                checkboxLabelMap.clear();
                loadBooks();
                viewBookDetails();
            }
        });

    }

    private static void viewBookDetails(){
        for (int i = 0; i < viewButtons.size(); i++) {
            JButton btn = viewButtons.get(i);
            JPanel myPanel = minDeletePanels2.get(i);

            JLabel finalLabels = null;
            for (Component component : myPanel.getComponents()) {
                if (component instanceof JLabel) {
                    finalLabels = (JLabel) component;
                    break;
                }
            }
            JLabel labels = finalLabels;
            if (labels != null) {
                checkboxLabelMap2.put(btn, labels);

                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String text = labels.getText();
                        System.out.println(text);

                        try {
                            File file = new File("books.txt");
                            BufferedReader br = new BufferedReader(new FileReader(file));
                            String line;

                            while ((line = br.readLine()) != null) {
                                String[] bookData = line.split(",");
                                String author2 = bookData[0].trim();
                                String title2 = bookData[1].trim();
                                String isbn2 = bookData[2].trim();
                                int publicationYear2 = Integer.parseInt(bookData[3].trim());
                                int totalCopies2 = Integer.parseInt(bookData[4].trim());

                                if (text.equals(title2)) {
                                    displayTitle.setText(title2);
                                    displayAuthor.setText(author2);
                                    displayISBN.setText(isbn2);
                                    displayPublicationYear.setText(String.valueOf(publicationYear2));
                                    displayTotalCopies.setText(String.valueOf(totalCopies2));
                                    break;
                                }
                            }

                            dialog2.setVisible(true);
                            br.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }

                    }
                });

                // Helper method to count the number of commas in a line

            } else {
                System.out.println("Something went wrong");
            }
        }
    }

    private static void loadBooks() {
        try {
            File myObj = new File("books.txt");
            Scanner myReader = new Scanner(myObj);
            int counter = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] bookData = data.split(","); // Split the line by comma
                counter++;
                String title2 = bookData[1];

                int totalCopies2 = Integer.parseInt(bookData[4]);

                copies.add(totalCopies2);

                minPanel = new JPanel(new GridLayout(0, 2));
                minPanel.setBackground(new Color(13, 23, 33));
                minPanel.setSize(300, 20);

                minDeletePanels2.add(minPanel);

                JLabel displayTitle = new JLabel(title2);
                displayTitle.setForeground(new Color(0xffffff));
                displayTitle.setFont(new Font("Arial", Font.BOLD, 16));

                viewDetailsButton = new JButton("VIEW");
                viewDetailsButton.setBackground(new Color(13, 23, 33));
                viewDetailsButton.setFocusPainted(false);
                viewDetailsButton.setFont(new Font("Arial", Font.PLAIN, 14));
                viewDetailsButton.setBorder(BorderFactory.createEmptyBorder());
                viewDetailsButton.setForeground(new Color(30, 144, 255));
                viewDetailsButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                detailLabels.add(displayTitle);
                minPanel.add(displayTitle);
                minPanel.add(viewDetailsButton);

                minPanel.setBorder(border);
                viewBookPanel.add(minPanel);
                viewButtons.add(viewDetailsButton);

            }
            text2.setText("" + counter);
            if (counter == 0) {
                noBooks.setVisible(true);
            }
            int sumOfTotalCopies = 0;
            for (int copy = 0; copy < copies.size(); copy++) {
                sumOfTotalCopies += copies.get(copy);
            }
            text4.setText("" + sumOfTotalCopies);
            myReader.close();
        } catch (FileNotFoundException exception) {
            System.out.println("An error occurred.");
            exception.printStackTrace();
        }

    }

    private static void refreshDeletePanel() {
        try {
            File myObj = new File("books.txt");
            Scanner myReader = new Scanner(myObj);
            int counter = 0;

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] bookData = data.split(",");
                counter++;

                String author2 = bookData[0];
                String title2 = bookData[1];
                String isbn2 = bookData[2];
                int publicationYear2 = Integer.parseInt(bookData[3]);
                int totalCopies2 = Integer.parseInt(bookData[4]);

                minPanel = new JPanel(new GridLayout(0, 1));
                minPanel.setBackground(new Color(13, 23, 33));

                deleteCheckbox = new JCheckBox();
                deleteCheckbox.setBackground(new Color(13, 23, 33));
                checkboxes.add(deleteCheckbox);
                minDeletePanels.add(minPanel);

                JLabel displayISBN = new JLabel(isbn2);
                displayISBN.setForeground(new Color(0xffffff));
                displayISBN.setFont(new Font("Arial", Font.PLAIN, 15));

                JLabel displayTitle = new JLabel(title2);
                displayTitle.setForeground(new Color(0xffffff));
                displayTitle.setFont(new Font("Arial", Font.PLAIN, 15));

                JLabel displayAuthor = new JLabel(author2);
                displayAuthor.setForeground(new Color(0xffffff));
                displayAuthor.setFont(new Font("Arial", Font.PLAIN, 15));

                JLabel displayPublicationYear = new JLabel("" + publicationYear2);
                displayPublicationYear.setForeground(new Color(0xffffff));
                displayPublicationYear.setFont(new Font("Arial", Font.PLAIN, 15));

                JLabel displayTotalCopies = new JLabel("" + totalCopies2);
                displayTotalCopies.setForeground(new Color(0xffffff));
                displayTotalCopies.setFont(new Font("Arial", Font.PLAIN, 15));

                detailLabels.add(displayTitle);
                detailLabels.add(displayAuthor);
                detailLabels.add(displayISBN);
                detailLabels.add(displayTotalCopies);
                detailLabels.add(displayPublicationYear);

                minPanel.add(deleteCheckbox);
                minPanel.add(displayISBN);
                minPanel.add(displayTitle);
                minPanel.add(displayAuthor);
                minPanel.add(displayPublicationYear);
                minPanel.add(displayTotalCopies);

                minPanel.setBorder(border);
                removeBookPanel.add(minPanel);
            }

        } catch (FileNotFoundException exception) {
            System.out.println("An error occurred.");
            exception.printStackTrace();
        }
    }

    static class addBookEvent implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            addBookPanel.setVisible(true);
            settingsPanel.setVisible(false);
            removeBookPanel.setVisible(false);
            scrollPane.setVisible(false);
            scrollPane3.setVisible(false);
            viewBookPanel2.setVisible(false);
            viewBookPanel.setVisible(false);
            removeBookPanel2.setVisible(false);
        }
    }

    static class removeBookEvent implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            settingsPanel.setVisible(false);
            addBookPanel.setVisible(false);
            removeBookPanel.setVisible(true);
            removeBookPanel2.setVisible(true);
            scrollPane3.setVisible(true);
            scrollPane.setVisible(false);
            viewBookPanel.setVisible(false);
            viewBookPanel2.setVisible(false);
        }
    }

    static class viewEvent implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            settingsPanel.setVisible(false);
            addBookPanel.setVisible(false);
            removeBookPanel.setVisible(false);
            scrollPane.setVisible(true);
            removeBookPanel2.setVisible(false);
            viewBookPanel2.setVisible(true);
            scrollPane3.setVisible(false);
            viewBookPanel.setVisible(true);
        }
    }

    static class settingsEvent implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            settingsPanel.setVisible(true);
            addBookPanel.setVisible(false);
            removeBookPanel.setVisible(false);
            viewBookPanel.setVisible(false);
            viewBookPanel2.setVisible(false);
            scrollPane.setVisible(false);
            scrollPane3.setVisible(false);
            removeBookPanel2.setVisible(false);
        }
    }

    static class saveEvent implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = titleField.getText();
            String author = authorField.getText();
            String ISBN = ISBNField.getText();
            String publicationYear = publicationYearField.getText();
            String totalCopies = totalCopiesField.getText();

            LocalDate currentDate = LocalDate.now();
            int currentYear = currentDate.getYear();
            if (title.isBlank()) {
                titleError.setText("Please Enter title...");
            }
            if (author.isBlank()) {
                authorError.setText("Please enter author name...");
            }
            if (ISBN.isBlank()) {
                ISBNError.setText("Please Enter ISBN...");
            }
            if (publicationYear.isBlank()) {
                publicationYearError.setText("Please enter publication year...");
            }
            if (totalCopies.isBlank()) {
                totalCopiesError.setText("Please enter number of total copies...");
            }
            if (!title.isBlank()) {
                titleError.setText("");
            }
            if (!author.isBlank()) {
                authorError.setText("");
            }
            if (!ISBN.isBlank()) {
                ISBNError.setText("");
            }
            if (!publicationYear.isBlank()) {
                publicationYearError.setText("");
            }
            if (!totalCopies.isBlank()) {
                totalCopiesError.setText("");
            }
            if (!title.isBlank() && !author.isBlank() && !ISBN.isBlank() && !publicationYear.isBlank()
                    && !totalCopies.isBlank()) {
                try {
                    int publicationYearInt = Integer.parseInt(publicationYear);
                    if (publicationYearInt >= 0 && publicationYearInt <= currentYear) {
                        try {
                            int totalCopiesInt = Integer.parseInt(totalCopies);
                            try {
                                FileWriter myWriter = new FileWriter("books.txt", true);
                                myWriter.write(author + "," + title + "," + ISBN + "," + publicationYearInt + ","
                                        + totalCopiesInt);
                                myWriter.write(System.lineSeparator());
                                myWriter.close();
                            } catch (IOException exception) {
                                System.out.println("An error occurred.");
                                exception.printStackTrace();
                            }
                            copies.clear();
                            viewBookPanel.removeAll();
                            removeBookPanel.removeAll();
                            refreshDeletePanel();
                            loadBooks();
                            viewBookDetails();
                            dialog.setVisible(true);
                            titleError.setText("");
                            authorError.setText("");
                            ISBNError.setText("");
                            publicationYearError.setText("");
                            totalCopiesError.setText("");
                            titleField.setText("");
                            authorField.setText("");
                            ISBNField.setText("");
                            publicationYearField.setText("");
                            totalCopiesField.setText("");
                        } catch (Exception exception) {
                            totalCopiesError.setText("Please Enter numbers only...");
                        }
                    } else {
                        publicationYearError.setText("Please enter Valid year...");
                    }
                } catch (Exception exception) {
                    publicationYearError.setText("Please Enter Numbers only...");
                }

            }

        }
    }

    static class resetEvent implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            titleField.setText("");
            authorField.setText("");
            ISBNField.setText("");
            publicationYearField.setText("");
            totalCopiesField.setText("");
            titleError.setText("");
            authorError.setText("");
            ISBNError.setText("");
            publicationYearError.setText("");
            totalCopiesError.setText("");
        }
    }

    static class exitEvent implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainFrame.dispose();
        }
    }

    static class checksAll implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (JCheckBox checkbox : checkboxes) {
                if (checkAll.isSelected()) {
                    checkbox.setSelected(true);
                } else {
                    checkbox.setSelected(false);
                }
            }

        }
    }

    static class changeThemeEvent implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (isThemeChanged) {
                // Revert to the original theme
                topPanel.setBackground(new Color(8, 15, 21));
                leftPanel.setBackground(new Color(8, 15, 21));
                addBookButton.setBackground(new Color(13, 23, 33));
                removeBookButton.setBackground(new Color(13, 23, 33));
                viewBooksButton.setBackground(new Color(13, 23, 33));
                changeThemeButton.setBackground(new Color(13, 23, 33));
                settingsButton.setBackground(new Color(13, 23, 33));
                settingsPanel.setBackground(new Color(13, 23, 33));
                exitButton.setBackground(new Color(13, 23, 33));
                addBookPanel.setBackground(new Color(13, 23, 33));
                viewBookPanel.setBackground(new Color(13, 23, 33));
                minPanel1.setBackground(new Color(8, 15, 21));
                centerPanel.setBackground(new Color(13, 23, 33));
                scrollPane.setBackground(new Color(13, 23, 33));
                scrollPane3.setBackground(new Color(13, 23, 33));
                removeBookPanel2.setBackground(new Color(13, 23, 33));
                mainFrame.getContentPane().setBackground(new Color(8, 15, 21));
                checkAllText.setForeground(Color.WHITE);
                checkAll.setBackground(new Color(13, 23, 33));
                savePanel.setBackground(new Color(13, 23, 33));
                textLabel.setForeground(Color.WHITE);
                for (JCheckBox checkbox : checkboxes) {
                    checkbox.setBackground(new Color(13, 23, 33));
                }
                for (JLabel detailLabel : detailLabels) {
                    detailLabel.setForeground(Color.WHITE);
                }
                for (JLabel detailLabel : detailLabels2) {
                    detailLabel.setForeground(Color.WHITE);
                }
                for (JPanel deletePanels : minDeletePanels) {
                    deletePanels.setBackground(new Color(13, 23, 33));
                    deletePanels.setForeground(Color.white);
                    deletePanels.setBorder(border);
                }
                for (JPanel deletePanels : minDeletePanels2) {
                    deletePanels.setBackground(new Color(13, 23, 33));
                    deletePanels.setForeground(Color.white);
                    deletePanels.setBorder(border);
                }
                for (JButton vb : viewButtons) {
                    vb.setBackground(new Color(13, 23, 33));
                    
                    }
                titleField.setBackground(new Color(13, 23, 33));
                titleField.setForeground(Color.WHITE);
                titleField.setCaretColor(Color.WHITE);
                titleLabel.setForeground(Color.WHITE);

                authorField.setBackground(new Color(13, 23, 33));
                authorField.setForeground(Color.WHITE);
                authorField.setCaretColor(Color.WHITE);
                authorLabel.setForeground(Color.WHITE);

                ISBNField.setBackground(new Color(13, 23, 33));
                ISBNField.setForeground(Color.WHITE);
                ISBNField.setCaretColor(Color.WHITE);
                ISBNLabel.setForeground(Color.WHITE);

                publicationYearField.setBackground(new Color(13, 23, 33));
                publicationYearField.setForeground(Color.WHITE);
                publicationYearField.setCaretColor(Color.WHITE);
                publicationYearLabel.setForeground(Color.WHITE);

                totalCopiesField.setBackground(new Color(13, 23, 33));
                totalCopiesField.setForeground(Color.WHITE);
                totalCopiesField.setCaretColor(Color.WHITE);
                totalCopiesLabel.setForeground(Color.WHITE);

            } else {
                // Apply the changed theme
                mainFrame.getContentPane().setBackground(new Color(0xffffff));
                topPanel.setBackground(new Color(0xA19A9A));
                leftPanel.setBackground(new Color(0xffffff));
                addBookButton.setBackground(new Color(0xA19A9A));
                removeBookButton.setBackground(new Color(0xA19A9A));
                changeThemeButton.setBackground(new Color(0xA19A9A));
                settingsButton.setBackground(new Color(0xA19A9A));
                viewBookPanel.setBackground(new Color(0xffffff));
                scrollPane.setBackground(new Color(0xffffff));
                viewBooksButton.setBackground(new Color(0xA19A9A));
                exitButton.setBackground(new Color(0xA19A9A));
                settingsPanel.setBackground(new Color(0xEAE4E4));
                addBookPanel.setBackground(new Color(0xEAE4E4));
                viewBookPanel.setBackground(new Color(0xEAE4E4));
                minPanel1.setBackground(new Color(0xffffff));
                centerPanel.setBackground(new Color(0xEAE4E4));
                removeBookPanel2.setBackground(new Color(0xffffff));
                scrollPane3.setBackground(new Color(0xffffff));
                checkAllText.setForeground(Color.BLACK);
                checkAll.setBackground(new Color(30, 144, 255));
                savePanel.setBackground(Color.white);
                textLabel.setForeground(Color.BLACK);

                scrollPane3.setBackground(new Color(0xA19A9A));
                for (JCheckBox checkbox : checkboxes) {
                    checkbox.setBackground(new Color(30, 144, 255));
                }
                for (JLabel detailLabel : detailLabels) {
                    detailLabel.setForeground(Color.BLACK);
                }
                for (JLabel detailLabel : detailLabels2) {
                    detailLabel.setForeground(Color.BLACK);
                }
                for (JPanel deletePanels : minDeletePanels) {
                    deletePanels.setBackground(Color.white);
                    deletePanels.setForeground(Color.BLACK);
                    deletePanels.setBorder(border2);
                }
                for (JPanel deletePanels : minDeletePanels2) {
                    deletePanels.setBackground(Color.white);
                    deletePanels.setForeground(Color.BLACK);
                    deletePanels.setBorder(border2);
                }
                for (JButton vb : viewButtons) {
                    vb.setBackground(new Color(0xffffff));
                }

                titleField.setBackground(new Color(0xffffff));
                titleField.setCaretColor(Color.BLACK);
                titleLabel.setForeground(Color.BLACK);
                titleField.setForeground(Color.BLACK);

                authorField.setBackground(new Color(0xffffff));
                authorField.setCaretColor(Color.BLACK);
                authorLabel.setForeground(Color.BLACK);
                authorField.setForeground(Color.BLACK);

                ISBNField.setBackground(new Color(0xffffff));
                ISBNField.setCaretColor(Color.BLACK);
                ISBNLabel.setForeground(Color.BLACK);
                ISBNField.setForeground(Color.BLACK);

                publicationYearField.setBackground(new Color(0xffffff));
                publicationYearField.setCaretColor(Color.BLACK);
                publicationYearLabel.setForeground(Color.BLACK);
                publicationYearField.setForeground(Color.BLACK);

                totalCopiesField.setBackground(new Color(0xffffff));
                totalCopiesField.setCaretColor(Color.BLACK);
                totalCopiesLabel.setForeground(Color.BLACK);
                totalCopiesField.setForeground(Color.BLACK);
            }

            // Toggle the theme state
            isThemeChanged = !isThemeChanged;
        }
    }

}