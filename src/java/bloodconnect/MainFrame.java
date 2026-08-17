package bloodconnect;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class MainFrame extends JFrame {

    // =====================================================
    // COLORS
    // =====================================================

    private final Color DARK_RED = new Color(150, 0, 0);
    private final Color RED = new Color(210, 30, 45);
    private final Color LIGHT_BG = new Color(248, 248, 248);
    private final Color WHITE = Color.WHITE;
    private final Color DARK_TEXT = new Color(40, 40, 40);


    // =====================================================
    // FONTS
    // =====================================================

    /*
     * Segoe UI Emoji is the Windows emoji font.
     * It allows Swing components to display emojis.
     */

    private final Font EMOJI_FONT =
            new Font(
                    "Segoe UI Emoji",
                    Font.PLAIN,
                    18
            );

    private final Font EMOJI_BOLD_FONT =
            new Font(
                    "Segoe UI Emoji",
                    Font.BOLD,
                    18
            );

    private final Font TITLE_FONT =
            new Font(
                    "Segoe UI Emoji",
                    Font.BOLD,
                    32
            );


    // =====================================================
    // DATABASE OPERATIONS
    // =====================================================

    private final DonorOperations donorOperations =
            new DonorOperations();

    private final RecipientOperations recipientOperations =
            new RecipientOperations();


    // =====================================================
    // CONSTRUCTOR
    // =====================================================

    public MainFrame() {

        setTitle(
                "BloodConnect - Blood Donation Management System"
        );

        setSize(900, 600);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setLocationRelativeTo(null);

        setResizable(false);

        createGUI();
    }


    // =====================================================
    // MAIN GUI
    // =====================================================

    private void createGUI() {

        JPanel mainPanel =
                new JPanel(
                        new BorderLayout()
                );

        mainPanel.setBackground(
                LIGHT_BG
        );


        // =================================================
        // HEADER
        // =================================================

        JPanel headerPanel =
                new JPanel();

        headerPanel.setBackground(
                DARK_RED
        );

        headerPanel.setPreferredSize(
                new Dimension(900, 125)
        );

        headerPanel.setLayout(
                new BoxLayout(
                        headerPanel,
                        BoxLayout.Y_AXIS
                )
        );


        JLabel title =
                new JLabel(
                        "🩸 BloodConnect ❤️"
                );

        title.setForeground(
                WHITE
        );

        title.setFont(
                TITLE_FONT
        );

        title.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        JLabel subtitle =
                new JLabel(
                        "🤝 Connecting Blood Donors & Recipients"
                );

        subtitle.setForeground(
                WHITE
        );

        subtitle.setFont(
                EMOJI_FONT
        );

        subtitle.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        headerPanel.add(
                Box.createVerticalGlue()
        );

        headerPanel.add(title);

        headerPanel.add(
                Box.createVerticalStrut(8)
        );

        headerPanel.add(subtitle);

        headerPanel.add(
                Box.createVerticalGlue()
        );


        // =================================================
        // BUTTON PANEL
        // =================================================

        JPanel centerPanel =
                new JPanel(
                        new GridLayout(
                                3,
                                2,
                                25,
                                25
                        )
                );

        centerPanel.setBackground(
                LIGHT_BG
        );

        centerPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        40,
                        80,
                        40,
                        80
                )
        );


        JButton addDonorButton =
                createButton(
                        "👤 Add Donor"
                );


        JButton addRecipientButton =
                createButton(
                        "🏥 Add Recipient"
                );


        JButton viewDonorButton =
                createButton(
                        "📋 View Donors"
                );


        JButton viewRecipientButton =
                createButton(
                        "📋 View Recipients"
                );


        JButton searchButton =
                createButton(
                        "🔍 Search Donor"
                );


        JButton matchButton =
                createButton(
                        "❤️ Blood Match"
                );


        centerPanel.add(addDonorButton);
        centerPanel.add(addRecipientButton);
        centerPanel.add(viewDonorButton);
        centerPanel.add(viewRecipientButton);
        centerPanel.add(searchButton);
        centerPanel.add(matchButton);


        // =================================================
        // FOOTER
        // =================================================

        JPanel footerPanel =
                new JPanel();

        footerPanel.setBackground(
                DARK_RED
        );

        footerPanel.setPreferredSize(
                new Dimension(900, 45)
        );


        JLabel footer =
                new JLabel(
                        "❤️ Donate Blood • Save Lives • Spread Hope ❤️"
                );

        footer.setForeground(
                WHITE
        );

        footer.setFont(
                EMOJI_BOLD_FONT
        );


        footerPanel.add(
                footer
        );


        // =================================================
        // ADD TO FRAME
        // =================================================

        mainPanel.add(
                headerPanel,
                BorderLayout.NORTH
        );

        mainPanel.add(
                centerPanel,
                BorderLayout.CENTER
        );

        mainPanel.add(
                footerPanel,
                BorderLayout.SOUTH
        );


        setContentPane(
                mainPanel
        );


        // =================================================
        // ACTIONS
        // =================================================

        addDonorButton.addActionListener(
                e -> openAddDonor()
        );

        addRecipientButton.addActionListener(
                e -> openAddRecipient()
        );

        viewDonorButton.addActionListener(
                e -> viewDonors()
        );

        viewRecipientButton.addActionListener(
                e -> viewRecipients()
        );

        searchButton.addActionListener(
                e -> searchDonor()
        );

        matchButton.addActionListener(
                e -> bloodMatch()
        );
    }


    // =====================================================
    // CREATE BUTTON
    // =====================================================

    private JButton createButton(String text) {

        JButton button =
                new JButton(text);

        button.setFont(
                EMOJI_BOLD_FONT
        );

        button.setForeground(
                DARK_TEXT
        );

        button.setBackground(
                WHITE
        );

        button.setFocusPainted(false);

        button.setBorder(
                BorderFactory.createLineBorder(
                        RED,
                        2
                )
        );

        return button;
    }


    // =====================================================
    // ADD DONOR
    // =====================================================

    private void openAddDonor() {

        JDialog dialog =
                new JDialog(
                        this,
                        "👤 Add Donor",
                        true
                );

        dialog.setSize(
                520,
                520
        );

        dialog.setLocationRelativeTo(
                this
        );

        dialog.setResizable(false);


        JPanel panel =
                new JPanel(
                        new GridBagLayout()
                );

        panel.setBackground(
                LIGHT_BG
        );

        panel.setBorder(
                BorderFactory.createEmptyBorder(
                        20,
                        30,
                        20,
                        30
                )
        );


        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets =
                new Insets(
                        8,
                        8,
                        8,
                        8
                );

        gbc.fill =
                GridBagConstraints.HORIZONTAL;


        // Heading

        JLabel heading =
                new JLabel(
                        "👤 ADD DONOR 🩸"
                );

        heading.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.BOLD,
                        24
                )
        );

        heading.setForeground(
                DARK_RED
        );

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        panel.add(
                heading,
                gbc
        );


        // Name

        gbc.gridwidth = 1;
        gbc.gridy++;

        panel.add(
                createLabel("👤 Name:"),
                gbc
        );

        JTextField nameField =
                new JTextField();

        gbc.gridx = 1;

        panel.add(
                nameField,
                gbc
        );


        // Age

        gbc.gridx = 0;
        gbc.gridy++;

        panel.add(
                createLabel("🎂 Age:"),
                gbc
        );

        JTextField ageField =
                new JTextField();

        gbc.gridx = 1;

        panel.add(
                ageField,
                gbc
        );


        // Gender

        gbc.gridx = 0;
        gbc.gridy++;

        panel.add(
                createLabel("⚧ Gender:"),
                gbc
        );

        JComboBox<String> genderBox =
                new JComboBox<>(
                        new String[]{
                                "Male",
                                "Female",
                                "Other"
                        }
                );

        genderBox.setFont(
                EMOJI_FONT
        );

        gbc.gridx = 1;

        panel.add(
                genderBox,
                gbc
        );


        // Blood Group

        gbc.gridx = 0;
        gbc.gridy++;

        panel.add(
                createLabel("🩸 Blood Group:"),
                gbc
        );

        JComboBox<String> bloodGroupBox =
                new JComboBox<>(
                        new String[]{
                                "O-",
                                "O+",
                                "A-",
                                "A+",
                                "B-",
                                "B+",
                                "AB-",
                                "AB+"
                        }
                );

        bloodGroupBox.setFont(
                EMOJI_FONT
        );

        gbc.gridx = 1;

        panel.add(
                bloodGroupBox,
                gbc
        );


        // Phone

        gbc.gridx = 0;
        gbc.gridy++;

        panel.add(
                createLabel("📱 Phone:"),
                gbc
        );

        JTextField phoneField =
                new JTextField();

        gbc.gridx = 1;

        panel.add(
                phoneField,
                gbc
        );


        // City

        gbc.gridx = 0;
        gbc.gridy++;

        panel.add(
                createLabel("📍 City:"),
                gbc
        );

        JTextField cityField =
                new JTextField();

        gbc.gridx = 1;

        panel.add(
                cityField,
                gbc
        );


        // Buttons

        JButton addButton =
                new JButton(
                        "✅ Add Donor"
                );

        JButton clearButton =
                new JButton(
                        "🧹 Clear"
                );

        JButton cancelButton =
                new JButton(
                        "❌ Cancel"
                );


        addButton.setFont(
                EMOJI_BOLD_FONT
        );

        clearButton.setFont(
                EMOJI_BOLD_FONT
        );

        cancelButton.setFont(
                EMOJI_BOLD_FONT
        );


        JPanel buttonPanel =
                new JPanel();

        buttonPanel.setBackground(
                LIGHT_BG
        );

        buttonPanel.add(addButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(cancelButton);


        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;

        panel.add(
                buttonPanel,
                gbc
        );


        // Add donor

        addButton.addActionListener(e -> {

            try {

                String name =
                        nameField
                                .getText()
                                .trim();

                String ageText =
                        ageField
                                .getText()
                                .trim();

                String gender =
                        genderBox
                                .getSelectedItem()
                                .toString();

                String bloodGroup =
                        bloodGroupBox
                                .getSelectedItem()
                                .toString();

                String phone =
                        phoneField
                                .getText()
                                .trim();

                String city =
                        cityField
                                .getText()
                                .trim();


                if (
                        name.isEmpty()
                        || ageText.isEmpty()
                        || phone.isEmpty()
                        || city.isEmpty()
                ) {

                    JOptionPane.showMessageDialog(
                            dialog,
                            "⚠️ Please fill all fields!",
                            "⚠️ Validation Error",
                            JOptionPane.WARNING_MESSAGE
                    );

                    return;
                }


                int age =
                        Integer.parseInt(
                                ageText
                        );


                if (age <= 0) {

                    JOptionPane.showMessageDialog(
                            dialog,
                            "⚠️ Age must be greater than 0.",
                            "⚠️ Invalid Age",
                            JOptionPane.WARNING_MESSAGE
                    );

                    return;
                }


                Donor donor =
                        new Donor(
                                name,
                                age,
                                gender,
                                bloodGroup,
                                phone,
                                city
                        );


                donorOperations.add(
                        donor
                );


                JOptionPane.showMessageDialog(
                        dialog,
                        "🎉 Donor added successfully! ❤️",
                        "✅ Success",
                        JOptionPane.INFORMATION_MESSAGE
                );


                dialog.dispose();


            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        dialog,
                        "⚠️ Age must be a number!",
                        "❌ Invalid Age",
                        JOptionPane.ERROR_MESSAGE
                );


            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        dialog,
                        "❌ Error: "
                                + ex.getMessage(),
                        "🚨 Database Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });


        // Clear

        clearButton.addActionListener(e -> {

            nameField.setText("");

            ageField.setText("");

            phoneField.setText("");

            cityField.setText("");

            genderBox.setSelectedIndex(0);

            bloodGroupBox.setSelectedIndex(0);
        });


        // Cancel

        cancelButton.addActionListener(
                e -> dialog.dispose()
        );


        dialog.add(panel);

        dialog.setVisible(true);
    }


    // =====================================================
    // ADD RECIPIENT
    // =====================================================

    private void openAddRecipient() {

        JDialog dialog =
                new JDialog(
                        this,
                        "🏥 Add Recipient",
                        true
                );

        dialog.setSize(
                520,
                570
        );

        dialog.setLocationRelativeTo(
                this
        );

        dialog.setResizable(false);


        JPanel panel =
                new JPanel(
                        new GridBagLayout()
                );

        panel.setBackground(
                LIGHT_BG
        );

        panel.setBorder(
                BorderFactory.createEmptyBorder(
                        20,
                        30,
                        20,
                        30
                )
        );


        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets =
                new Insets(
                        8,
                        8,
                        8,
                        8
                );

        gbc.fill =
                GridBagConstraints.HORIZONTAL;


        JLabel heading =
                new JLabel(
                        "🏥 ADD RECIPIENT 🩸"
                );

        heading.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.BOLD,
                        24
                )
        );

        heading.setForeground(
                DARK_RED
        );

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        panel.add(
                heading,
                gbc
        );


        // Name

        gbc.gridwidth = 1;
        gbc.gridy++;

        panel.add(
                createLabel("👤 Name:"),
                gbc
        );

        JTextField nameField =
                new JTextField();

        gbc.gridx = 1;

        panel.add(
                nameField,
                gbc
        );


        // Age

        gbc.gridx = 0;
        gbc.gridy++;

        panel.add(
                createLabel("🎂 Age:"),
                gbc
        );

        JTextField ageField =
                new JTextField();

        gbc.gridx = 1;

        panel.add(
                ageField,
                gbc
        );


        // Gender

        gbc.gridx = 0;
        gbc.gridy++;

        panel.add(
                createLabel("⚧ Gender:"),
                gbc
        );

        JComboBox<String> genderBox =
                new JComboBox<>(
                        new String[]{
                                "Male",
                                "Female",
                                "Other"
                        }
                );

        genderBox.setFont(
                EMOJI_FONT
        );

        gbc.gridx = 1;

        panel.add(
                genderBox,
                gbc
        );


        // Blood Group

        gbc.gridx = 0;
        gbc.gridy++;

        panel.add(
                createLabel("🩸 Blood Group:"),
                gbc
        );

        JComboBox<String> bloodGroupBox =
                new JComboBox<>(
                        new String[]{
                                "O-",
                                "O+",
                                "A-",
                                "A+",
                                "B-",
                                "B+",
                                "AB-",
                                "AB+"
                        }
                );

        bloodGroupBox.setFont(
                EMOJI_FONT
        );

        gbc.gridx = 1;

        panel.add(
                bloodGroupBox,
                gbc
        );


        // Phone

        gbc.gridx = 0;
        gbc.gridy++;

        panel.add(
                createLabel("📱 Phone:"),
                gbc
        );

        JTextField phoneField =
                new JTextField();

        gbc.gridx = 1;

        panel.add(
                phoneField,
                gbc
        );


        // Hospital

        gbc.gridx = 0;
        gbc.gridy++;

        panel.add(
                createLabel("🏥 Hospital:"),
                gbc
        );

        JTextField hospitalField =
                new JTextField();

        gbc.gridx = 1;

        panel.add(
                hospitalField,
                gbc
        );


        // City

        gbc.gridx = 0;
        gbc.gridy++;

        panel.add(
                createLabel("📍 City:"),
                gbc
        );

        JTextField cityField =
                new JTextField();

        gbc.gridx = 1;

        panel.add(
                cityField,
                gbc
        );


        // Buttons

        JButton addButton =
                new JButton(
                        "✅ Add Recipient"
                );

        JButton clearButton =
                new JButton(
                        "🧹 Clear"
                );

        JButton cancelButton =
                new JButton(
                        "❌ Cancel"
                );


        addButton.setFont(
                EMOJI_BOLD_FONT
        );

        clearButton.setFont(
                EMOJI_BOLD_FONT
        );

        cancelButton.setFont(
                EMOJI_BOLD_FONT
        );


        JPanel buttonPanel =
                new JPanel();

        buttonPanel.setBackground(
                LIGHT_BG
        );

        buttonPanel.add(addButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(cancelButton);


        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;

        panel.add(
                buttonPanel,
                gbc
        );


        // Add recipient

        addButton.addActionListener(e -> {

            try {

                String name =
                        nameField
                                .getText()
                                .trim();

                String ageText =
                        ageField
                                .getText()
                                .trim();

                String gender =
                        genderBox
                                .getSelectedItem()
                                .toString();

                String bloodGroup =
                        bloodGroupBox
                                .getSelectedItem()
                                .toString();

                String phone =
                        phoneField
                                .getText()
                                .trim();

                String hospital =
                        hospitalField
                                .getText()
                                .trim();

                String city =
                        cityField
                                .getText()
                                .trim();


                if (
                        name.isEmpty()
                        || ageText.isEmpty()
                        || phone.isEmpty()
                        || hospital.isEmpty()
                        || city.isEmpty()
                ) {

                    JOptionPane.showMessageDialog(
                            dialog,
                            "⚠️ Please fill all fields!",
                            "⚠️ Validation Error",
                            JOptionPane.WARNING_MESSAGE
                    );

                    return;
                }


                int age =
                        Integer.parseInt(
                                ageText
                        );


                if (age <= 0) {

                    JOptionPane.showMessageDialog(
                            dialog,
                            "⚠️ Age must be greater than 0.",
                            "⚠️ Invalid Age",
                            JOptionPane.WARNING_MESSAGE
                    );

                    return;
                }


                Recipient recipient =
                        new Recipient(
                                name,
                                age,
                                gender,
                                bloodGroup,
                                phone,
                                hospital,
                                city
                        );


                recipientOperations.add(
                        recipient
                );


                JOptionPane.showMessageDialog(
                        dialog,
                        "🎉 Recipient added successfully! 🏥",
                        "✅ Success",
                        JOptionPane.INFORMATION_MESSAGE
                );


                dialog.dispose();


            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        dialog,
                        "⚠️ Age must be a number!",
                        "❌ Invalid Age",
                        JOptionPane.ERROR_MESSAGE
                );


            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        dialog,
                        "❌ Error: "
                                + ex.getMessage(),
                        "🚨 Database Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });


        // Clear

        clearButton.addActionListener(e -> {

            nameField.setText("");

            ageField.setText("");

            phoneField.setText("");

            hospitalField.setText("");

            cityField.setText("");

            genderBox.setSelectedIndex(0);

            bloodGroupBox.setSelectedIndex(0);
        });


        // Cancel

        cancelButton.addActionListener(
                e -> dialog.dispose()
        );


        dialog.add(panel);

        dialog.setVisible(true);
    }


    // =====================================================
    // LABEL CREATOR
    // =====================================================

    private JLabel createLabel(
            String text) {

        JLabel label =
                new JLabel(text);

        label.setFont(
                EMOJI_BOLD_FONT
        );

        label.setForeground(
                DARK_TEXT
        );

        return label;
    }


    // =====================================================
    // VIEW DONORS
    // =====================================================

    private void viewDonors() {

        try {

            ArrayList<Donor> donors =
                    donorOperations.getAll();


            String[] columns = {
                    "ID",
                    "Name",
                    "Age",
                    "Gender",
                    "Blood Group",
                    "Phone",
                    "City"
            };


            Object[][] data =
                    new Object[
                            donors.size()
                    ][7];


            for (
                    int i = 0;
                    i < donors.size();
                    i++
            ) {

                Donor d =
                        donors.get(i);

                data[i][0] = i + 1;
                data[i][1] = d.getName();
                data[i][2] = d.getAge();
                data[i][3] = d.getGender();
                data[i][4] = d.getBloodGroup();
                data[i][5] = d.getPhone();
                data[i][6] = d.getCity();
            }


            JTable table =
                    new JTable(
                            data,
                            columns
                    );


            table.setRowHeight(28);


            JScrollPane scrollPane =
                    new JScrollPane(table);


            JDialog dialog =
                    new JDialog(
                            this,
                            "📋 All Donors",
                            true
                    );


            dialog.setSize(
                    850,
                    400
            );


            dialog.setLocationRelativeTo(
                    this
            );


            dialog.add(
                    scrollPane
            );


            dialog.setVisible(true);


        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "❌ Error: "
                            + ex.getMessage(),
                    "🚨 Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }


    // =====================================================
    // VIEW RECIPIENTS
    // =====================================================

    private void viewRecipients() {

        try {

            ArrayList<Recipient> recipients =
                    recipientOperations.getAll();


            String[] columns = {
                    "ID",
                    "Name",
                    "Age",
                    "Gender",
                    "Blood Group",
                    "Phone",
                    "Hospital",
                    "City"
            };


            Object[][] data =
                    new Object[
                            recipients.size()
                    ][8];


            for (
                    int i = 0;
                    i < recipients.size();
                    i++
            ) {

                Recipient r =
                        recipients.get(i);

                data[i][0] = i + 1;
                data[i][1] = r.getName();
                data[i][2] = r.getAge();
                data[i][3] = r.getGender();
                data[i][4] = r.getBloodGroup();
                data[i][5] = r.getPhone();
                data[i][6] = r.getHospital();
                data[i][7] = r.getCity();
            }


            JTable table =
                    new JTable(
                            data,
                            columns
                    );


            table.setRowHeight(28);


            JScrollPane scrollPane =
                    new JScrollPane(table);


            JDialog dialog =
                    new JDialog(
                            this,
                            "📋 All Recipients",
                            true
                    );


            dialog.setSize(
                    950,
                    400
            );


            dialog.setLocationRelativeTo(
                    this
            );


            dialog.add(
                    scrollPane
            );


            dialog.setVisible(true);


        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "❌ Error: "
                            + ex.getMessage(),
                    "🚨 Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }


    // =====================================================
    // SEARCH DONOR
    // =====================================================

    private void searchDonor() {

        String[] groups = {
                "O-",
                "O+",
                "A-",
                "A+",
                "B-",
                "B+",
                "AB-",
                "AB+"
        };


        String bloodGroup =
                (String) JOptionPane.showInputDialog(
                        this,
                        "🩸 Select blood group:",
                        "🔍 Search Donor",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        groups,
                        groups[1]
                );


        if (bloodGroup == null) {
            return;
        }


        try {

            ArrayList<Donor> donors =
                    donorOperations
                            .searchByBloodGroup(
                                    bloodGroup
                            );


            if (donors.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "😔 No donor found for "
                                + bloodGroup,
                        "🔍 Search Result",
                        JOptionPane.INFORMATION_MESSAGE
                );

                return;
            }


            StringBuilder result =
                    new StringBuilder();


            result.append(
                    "🩸 AVAILABLE DONORS\n\n"
            );


            int number = 1;


            for (Donor d : donors) {

                result.append(
                        "👤 Donor "
                                + number
                                + "\n"
                );

                result.append(
                        "Name: "
                                + d.getName()
                                + "\n"
                );

                result.append(
                        "🩸 Blood Group: "
                                + d.getBloodGroup()
                                + "\n"
                );

                result.append(
                        "📱 Phone: "
                                + d.getPhone()
                                + "\n"
                );

                result.append(
                        "📍 City: "
                                + d.getCity()
                                + "\n"
                );

                result.append(
                        "----------------------\n"
                );

                number++;
            }


            JTextArea textArea =
                    new JTextArea(
                            result.toString()
                    );


            textArea.setEditable(false);


            textArea.setFont(
                    EMOJI_FONT
            );


            JScrollPane scrollPane =
                    new JScrollPane(
                            textArea
                    );


            scrollPane.setPreferredSize(
                    new Dimension(
                            500,
                            350
                    )
            );


            JOptionPane.showMessageDialog(
                    this,
                    scrollPane,
                    "🔍 Search Result",
                    JOptionPane.INFORMATION_MESSAGE
            );


        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "❌ Error: "
                            + ex.getMessage(),
                    "🚨 Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }


    // =====================================================
    // BLOOD MATCH
    // =====================================================

    private void bloodMatch() {

        String[] groups = {
                "O-",
                "O+",
                "A-",
                "A+",
                "B-",
                "B+",
                "AB-",
                "AB+"
        };


        String bloodGroup =
                (String) JOptionPane.showInputDialog(
                        this,
                        "🩸 Select recipient blood group:",
                        "❤️ Blood Matching",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        groups,
                        groups[1]
                );


        if (bloodGroup == null) {
            return;
        }


        try {

            ArrayList<Donor> donors =
                    donorOperations
                            .findCompatibleDonors(
                                    bloodGroup
                            );


            if (donors.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "😔 No compatible donor found.",
                        "❤️ Blood Match",
                        JOptionPane.INFORMATION_MESSAGE
                );

                return;
            }


            StringBuilder result =
                    new StringBuilder();


            result.append(
                    "❤️ BLOOD MATCH RESULTS 🩸\n\n"
            );


            result.append(
                    "Recipient Blood Group: "
                            + bloodGroup
                            + "\n\n"
            );


            int number = 1;


            for (Donor d : donors) {

                result.append(
                        "👤 Donor "
                                + number
                                + "\n"
                );

                result.append(
                        "Name: "
                                + d.getName()
                                + "\n"
                );

                result.append(
                        "🩸 Blood Group: "
                                + d.getBloodGroup()
                                + "\n"
                );

                result.append(
                        "📱 Phone: "
                                + d.getPhone()
                                + "\n"
                );

                result.append(
                        "📍 City: "
                                + d.getCity()
                                + "\n"
                );

                result.append(
                        "----------------------\n"
                );

                number++;
            }


            JTextArea textArea =
                    new JTextArea(
                            result.toString()
                    );


            textArea.setEditable(false);


            textArea.setFont(
                    EMOJI_FONT
            );


            JScrollPane scrollPane =
                    new JScrollPane(
                            textArea
                    );


            scrollPane.setPreferredSize(
                    new Dimension(
                            500,
                            350
                    )
            );


            JOptionPane.showMessageDialog(
                    this,
                    scrollPane,
                    "❤️ Blood Match Results",
                    JOptionPane.INFORMATION_MESSAGE
            );


        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "❌ Error: "
                            + ex.getMessage(),
                    "🚨 Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}