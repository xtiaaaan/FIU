namespace COP4226_Assignment4_WallpaperDesign
{
    partial class PickLinearGradientBrush
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
            this.ok = new System.Windows.Forms.Button();
            this.cancel = new System.Windows.Forms.Button();
            this.colorDialog1 = new System.Windows.Forms.ColorDialog();
            this.numericUpDown1 = new System.Windows.Forms.NumericUpDown();
            this.startingColor = new System.Windows.Forms.Button();
            this.endingColor = new System.Windows.Forms.Button();
            this.colorDialog2 = new System.Windows.Forms.ColorDialog();
            this.diagonal = new System.Windows.Forms.RadioButton();
            this.vertical = new System.Windows.Forms.RadioButton();
            this.horizontal = new System.Windows.Forms.RadioButton();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown1)).BeginInit();
            this.SuspendLayout();
            // 
            // ok
            // 
            this.ok.DialogResult = System.Windows.Forms.DialogResult.OK;
            this.ok.Location = new System.Drawing.Point(82, 281);
            this.ok.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.ok.Name = "ok";
            this.ok.Size = new System.Drawing.Size(87, 26);
            this.ok.TabIndex = 2;
            this.ok.Text = "OK";
            this.ok.UseVisualStyleBackColor = true;
            // 
            // cancel
            // 
            this.cancel.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.cancel.Location = new System.Drawing.Point(259, 281);
            this.cancel.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.cancel.Name = "cancel";
            this.cancel.Size = new System.Drawing.Size(87, 26);
            this.cancel.TabIndex = 3;
            this.cancel.Text = "Cancel";
            this.cancel.UseVisualStyleBackColor = true;
            // 
            // numericUpDown1
            // 
            this.numericUpDown1.Location = new System.Drawing.Point(159, 111);
            this.numericUpDown1.Margin = new System.Windows.Forms.Padding(2);
            this.numericUpDown1.Name = "numericUpDown1";
            this.numericUpDown1.Size = new System.Drawing.Size(107, 23);
            this.numericUpDown1.TabIndex = 4;
            this.numericUpDown1.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            this.numericUpDown1.ValueChanged += new System.EventHandler(this.numericUpDown1_ValueChanged);
            // 
            // startingColor
            // 
            this.startingColor.Location = new System.Drawing.Point(82, 226);
            this.startingColor.Margin = new System.Windows.Forms.Padding(2);
            this.startingColor.Name = "startingColor";
            this.startingColor.Size = new System.Drawing.Size(87, 24);
            this.startingColor.TabIndex = 6;
            this.startingColor.Text = "startingColor";
            this.startingColor.UseVisualStyleBackColor = true;
            this.startingColor.Click += new System.EventHandler(this.startingColor_Click);
            // 
            // endingColor
            // 
            this.endingColor.Location = new System.Drawing.Point(259, 226);
            this.endingColor.Margin = new System.Windows.Forms.Padding(2);
            this.endingColor.Name = "endingColor";
            this.endingColor.Size = new System.Drawing.Size(87, 24);
            this.endingColor.TabIndex = 7;
            this.endingColor.Text = "endingColor";
            this.endingColor.UseVisualStyleBackColor = true;
            this.endingColor.Click += new System.EventHandler(this.endingColor_Click);
            // 
            // diagonal
            // 
            this.diagonal.AutoSize = true;
            this.diagonal.Location = new System.Drawing.Point(101, 188);
            this.diagonal.Margin = new System.Windows.Forms.Padding(2);
            this.diagonal.Name = "diagonal";
            this.diagonal.Size = new System.Drawing.Size(72, 19);
            this.diagonal.TabIndex = 9;
            this.diagonal.Text = "Diagonal";
            this.diagonal.UseVisualStyleBackColor = true;
            this.diagonal.CheckedChanged += new System.EventHandler(this.diagonal_Checked);
            // 
            // vertical
            // 
            this.vertical.AutoSize = true;
            this.vertical.Location = new System.Drawing.Point(177, 188);
            this.vertical.Margin = new System.Windows.Forms.Padding(2);
            this.vertical.Name = "vertical";
            this.vertical.Size = new System.Drawing.Size(63, 19);
            this.vertical.TabIndex = 10;
            this.vertical.Text = "Vertical";
            this.vertical.UseVisualStyleBackColor = true;
            this.vertical.CheckedChanged += new System.EventHandler(this.vertical_Checked);
            // 
            // horizontal
            // 
            this.horizontal.AutoSize = true;
            this.horizontal.Checked = true;
            this.horizontal.Location = new System.Drawing.Point(244, 188);
            this.horizontal.Margin = new System.Windows.Forms.Padding(2);
            this.horizontal.Name = "horizontal";
            this.horizontal.Size = new System.Drawing.Size(80, 19);
            this.horizontal.TabIndex = 11;
            this.horizontal.TabStop = true;
            this.horizontal.Text = "Horizontal";
            this.horizontal.UseVisualStyleBackColor = true;
            this.horizontal.CheckedChanged += new System.EventHandler(this.horizontal_Checked);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(159, 94);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(106, 15);
            this.label1.TabIndex = 12;
            this.label1.Text = "Length of Gradient";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(168, 162);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(86, 15);
            this.label2.TabIndex = 13;
            this.label2.Text = "Gradient Mode";
            // 
            // PickLinearGradientBrush
            // 
            this.AcceptButton = this.ok;
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.CancelButton = this.cancel;
            this.ClientSize = new System.Drawing.Size(446, 322);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.horizontal);
            this.Controls.Add(this.vertical);
            this.Controls.Add(this.diagonal);
            this.Controls.Add(this.endingColor);
            this.Controls.Add(this.startingColor);
            this.Controls.Add(this.numericUpDown1);
            this.Controls.Add(this.cancel);
            this.Controls.Add(this.ok);
            this.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.Name = "PickLinearGradientBrush";
            this.Text = "Pick Linear Gradient";
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button startingColor;
        private System.Windows.Forms.Button endingColor;
        private System.Windows.Forms.Button ok;
        private System.Windows.Forms.Button cancel;
        private System.Windows.Forms.ColorDialog colorDialog1;
        private System.Windows.Forms.ColorDialog colorDialog2;
        internal Color pickedColor;
        private System.Windows.Forms.NumericUpDown numericUpDown1;
        private System.Windows.Forms.RadioButton diagonal;
        private System.Windows.Forms.RadioButton vertical;
        private System.Windows.Forms.RadioButton horizontal;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
    }
}