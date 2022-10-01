using System.Windows.Forms.VisualStyles;

namespace COP4226_Assignment2_Minesweeper
{
    partial class MainForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.button1 = new System.Windows.Forms.Button();
            this.easy = new System.Windows.Forms.RadioButton();
            this.medium = new System.Windows.Forms.RadioButton();
            this.expert = new System.Windows.Forms.RadioButton();
            this.custom = new System.Windows.Forms.RadioButton();
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.playANewGameToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.easyMenu = new System.Windows.Forms.ToolStripMenuItem();
            this.mediumMenu = new System.Windows.Forms.ToolStripMenuItem();
            this.expertMenu = new System.Windows.Forms.ToolStripMenuItem();
            this.closeAllGamesToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.exitToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.gamesOpen = new System.Windows.Forms.TextBox();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.menuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(236, 93);
            this.button1.Margin = new System.Windows.Forms.Padding(4, 3, 4, 3);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(88, 27);
            this.button1.TabIndex = 0;
            this.button1.Text = "Play";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.Play);
            // 
            // easy
            // 
            this.easy.AutoSize = true;
            this.easy.Location = new System.Drawing.Point(149, 68);
            this.easy.Margin = new System.Windows.Forms.Padding(4, 3, 4, 3);
            this.easy.Name = "easy";
            this.easy.Size = new System.Drawing.Size(48, 19);
            this.easy.TabIndex = 1;
            this.easy.TabStop = true;
            this.easy.Text = "Easy";
            this.easy.UseVisualStyleBackColor = true;
            this.easy.CheckedChanged += new System.EventHandler(this.radioButton1_CheckedChanged);
            // 
            // medium
            // 
            this.medium.AutoSize = true;
            this.medium.Checked = true;
            this.medium.Location = new System.Drawing.Point(205, 68);
            this.medium.Margin = new System.Windows.Forms.Padding(4, 3, 4, 3);
            this.medium.Name = "medium";
            this.medium.Size = new System.Drawing.Size(70, 19);
            this.medium.TabIndex = 2;
            this.medium.TabStop = true;
            this.medium.Text = "Medium";
            this.medium.UseVisualStyleBackColor = true;
            this.medium.CheckedChanged += new System.EventHandler(this.radioButton2_CheckedChanged);
            // 
            // expert
            // 
            this.expert.AutoSize = true;
            this.expert.Location = new System.Drawing.Point(283, 68);
            this.expert.Margin = new System.Windows.Forms.Padding(4, 3, 4, 3);
            this.expert.Name = "expert";
            this.expert.Size = new System.Drawing.Size(58, 19);
            this.expert.TabIndex = 3;
            this.expert.TabStop = true;
            this.expert.Text = "Expert";
            this.expert.UseVisualStyleBackColor = true;
            this.expert.CheckedChanged += new System.EventHandler(this.radioButton3_CheckedChanged);
            // 
            // custom
            // 
            this.custom.AutoSize = true;
            this.custom.Location = new System.Drawing.Point(348, 68);
            this.custom.Name = "custom";
            this.custom.Size = new System.Drawing.Size(67, 19);
            this.custom.TabIndex = 4;
            this.custom.TabStop = true;
            this.custom.Text = "Custom";
            this.custom.UseVisualStyleBackColor = true;
            this.custom.CheckedChanged += new System.EventHandler(this.radioButton4_CheckedChanged);
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.playANewGameToolStripMenuItem,
            this.closeAllGamesToolStripMenuItem,
            this.exitToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(580, 24);
            this.menuStrip1.TabIndex = 5;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // playANewGameToolStripMenuItem
            // 
            this.playANewGameToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.easyMenu,
            this.mediumMenu,
            this.expertMenu});
            this.playANewGameToolStripMenuItem.Name = "playANewGameToolStripMenuItem";
            this.playANewGameToolStripMenuItem.Size = new System.Drawing.Size(111, 20);
            this.playANewGameToolStripMenuItem.Text = "Play a New Game";
            // 
            // easyMenu
            // 
            this.easyMenu.Name = "easyMenu";
            this.easyMenu.Size = new System.Drawing.Size(119, 22);
            this.easyMenu.Text = "Easy";
            this.easyMenu.Click += new System.EventHandler(this.easyMenuStrip_Pressed);
            // 
            // mediumMenu
            // 
            this.mediumMenu.Name = "mediumMenu";
            this.mediumMenu.Size = new System.Drawing.Size(119, 22);
            this.mediumMenu.Text = "Medium";
            this.mediumMenu.Click += new System.EventHandler(this.mediumMenuStrip_Pressed);
            // 
            // expertMenu
            // 
            this.expertMenu.Name = "expertMenu";
            this.expertMenu.Size = new System.Drawing.Size(119, 22);
            this.expertMenu.Text = "Expert";
            this.expertMenu.Click += new System.EventHandler(this.expertMenuStrip_Pressed);
            // 
            // closeAllGamesToolStripMenuItem
            // 
            this.closeAllGamesToolStripMenuItem.Name = "closeAllGamesToolStripMenuItem";
            this.closeAllGamesToolStripMenuItem.Size = new System.Drawing.Size(104, 20);
            this.closeAllGamesToolStripMenuItem.Text = "Close All Games";
            this.closeAllGamesToolStripMenuItem.Click += new System.EventHandler(this.closeGames_pressed);
            // 
            // exitToolStripMenuItem
            // 
            this.exitToolStripMenuItem.Name = "exitToolStripMenuItem";
            this.exitToolStripMenuItem.Size = new System.Drawing.Size(38, 20);
            this.exitToolStripMenuItem.Text = "Exit";
            this.exitToolStripMenuItem.Click += new System.EventHandler(this.exit_Pressed);
            // 
            // gamesOpen
            // 
            this.gamesOpen.ImeMode = System.Windows.Forms.ImeMode.Off;
            this.gamesOpen.Location = new System.Drawing.Point(480, 172);
            this.gamesOpen.Name = "gamesOpen";
            this.gamesOpen.ReadOnly = true;
            this.gamesOpen.Size = new System.Drawing.Size(100, 23);
            this.gamesOpen.TabIndex = 6;
            this.gamesOpen.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(12, 172);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(100, 23);
            this.textBox1.TabIndex = 7;
            // 
            // MainForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(580, 207);
            this.Controls.Add(this.textBox1);
            this.Controls.Add(this.gamesOpen);
            this.Controls.Add(this.custom);
            this.Controls.Add(this.expert);
            this.Controls.Add(this.medium);
            this.Controls.Add(this.easy);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.menuStrip1);
            this.MainMenuStrip = this.menuStrip1;
            this.Margin = new System.Windows.Forms.Padding(4, 3, 4, 3);
            this.Name = "MainForm";
            this.Text = "MineSweeper";
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.RadioButton easy;
        private System.Windows.Forms.RadioButton medium;
        private System.Windows.Forms.RadioButton expert;
        private System.Windows.Forms.RadioButton custom;
        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem playANewGameToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem easyMenu;
        private System.Windows.Forms.ToolStripMenuItem mediumMenu;
        private System.Windows.Forms.ToolStripMenuItem expertMenu;
        private System.Windows.Forms.ToolStripMenuItem closeAllGamesToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem exitToolStripMenuItem;
        private System.Windows.Forms.TextBox gamesOpen;
        private TextBox textBox1;
    }
}

