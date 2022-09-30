namespace COP4226_Assignment2_Minesweeper
{
    partial class Form3
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
            this.rowBox = new System.Windows.Forms.TextBox();
            this.columnBox = new System.Windows.Forms.TextBox();
            this.minesBox = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.ok = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // rowBox
            // 
            this.rowBox.Location = new System.Drawing.Point(69, 36);
            this.rowBox.Name = "rowBox";
            this.rowBox.Size = new System.Drawing.Size(100, 23);
            this.rowBox.TabIndex = 0;
            // 
            // columnBox
            // 
            this.columnBox.Location = new System.Drawing.Point(68, 65);
            this.columnBox.Name = "columnBox";
            this.columnBox.Size = new System.Drawing.Size(100, 23);
            this.columnBox.TabIndex = 1;
            // 
            // minesBox
            // 
            this.minesBox.Location = new System.Drawing.Point(68, 94);
            this.minesBox.Name = "minesBox";
            this.minesBox.Size = new System.Drawing.Size(100, 23);
            this.minesBox.TabIndex = 2;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(12, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(264, 15);
            this.label1.TabIndex = 3;
            this.label1.Text = "Please Input Row, Column and Mine Parameters:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(12, 39);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(30, 15);
            this.label2.TabIndex = 4;
            this.label2.Text = "Row";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(12, 68);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(50, 15);
            this.label3.TabIndex = 5;
            this.label3.Text = "Column";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(12, 97);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(39, 15);
            this.label4.TabIndex = 6;
            this.label4.Text = "Mines";
            // 
            // ok
            // 
            this.ok.DialogResult = System.Windows.Forms.DialogResult.OK;
            this.ok.Location = new System.Drawing.Point(197, 127);
            this.ok.Name = "ok";
            this.ok.Size = new System.Drawing.Size(75, 23);
            this.ok.TabIndex = 7;
            this.ok.Text = "OK";
            this.ok.UseVisualStyleBackColor = true;
            this.ok.Click += new System.EventHandler(this.okay_Click);
            // 
            // Form3
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(284, 162);
            this.Controls.Add(this.ok);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.minesBox);
            this.Controls.Add(this.columnBox);
            this.Controls.Add(this.rowBox);
            this.Name = "Form3";
            this.Text = "Form3";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private TextBox rowBox;
        private TextBox columnBox;
        private TextBox minesBox;
        private Label label1;
        private Label label2;
        private Label label3;
        private Label label4;
        private Button ok;
    }
}