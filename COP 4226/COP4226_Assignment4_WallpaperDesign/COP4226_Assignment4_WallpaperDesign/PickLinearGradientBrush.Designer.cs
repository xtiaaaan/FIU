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
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.startingColor = new System.Windows.Forms.Button();
            this.endingColor = new System.Windows.Forms.Button();
            this.colorDialog2 = new System.Windows.Forms.ColorDialog();
            this.textBox2 = new System.Windows.Forms.TextBox();
            this.diagonal = new System.Windows.Forms.RadioButton();
            this.vertical = new System.Windows.Forms.RadioButton();
            this.horizontal = new System.Windows.Forms.RadioButton();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown1)).BeginInit();
            this.SuspendLayout();
            // 
            // ok
            // 
            this.ok.DialogResult = System.Windows.Forms.DialogResult.OK;
            this.ok.Location = new System.Drawing.Point(105, 375);
            this.ok.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.ok.Name = "ok";
            this.ok.Size = new System.Drawing.Size(112, 35);
            this.ok.TabIndex = 2;
            this.ok.Text = "OK";
            this.ok.UseVisualStyleBackColor = true;
            // 
            // cancel
            // 
            this.cancel.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.cancel.Location = new System.Drawing.Point(333, 375);
            this.cancel.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.cancel.Name = "cancel";
            this.cancel.Size = new System.Drawing.Size(112, 35);
            this.cancel.TabIndex = 3;
            this.cancel.Text = "Cancel";
            this.cancel.UseVisualStyleBackColor = true;
            // 
            // numericUpDown1
            // 
            this.numericUpDown1.Location = new System.Drawing.Point(205, 148);
            this.numericUpDown1.Name = "numericUpDown1";
            this.numericUpDown1.Size = new System.Drawing.Size(137, 26);
            this.numericUpDown1.TabIndex = 4;
            this.numericUpDown1.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(205, 58);
            this.textBox1.Name = "textBox1";
            this.textBox1.ReadOnly = true;
            this.textBox1.Size = new System.Drawing.Size(137, 26);
            this.textBox1.TabIndex = 5;
            this.textBox1.Text = "Length of gradient";
            // 
            // startingColor
            // 
            this.startingColor.Location = new System.Drawing.Point(105, 302);
            this.startingColor.Name = "startingColor";
            this.startingColor.Size = new System.Drawing.Size(112, 32);
            this.startingColor.TabIndex = 6;
            this.startingColor.Text = "startingColor";
            this.startingColor.UseVisualStyleBackColor = true;
            // 
            // endingColor
            // 
            this.endingColor.Location = new System.Drawing.Point(333, 302);
            this.endingColor.Name = "endingColor";
            this.endingColor.Size = new System.Drawing.Size(112, 32);
            this.endingColor.TabIndex = 7;
            this.endingColor.Text = "endingColor";
            this.endingColor.UseVisualStyleBackColor = true;
            // 
            // textBox2
            // 
            this.textBox2.Location = new System.Drawing.Point(181, 180);
            this.textBox2.Name = "textBox2";
            this.textBox2.ReadOnly = true;
            this.textBox2.Size = new System.Drawing.Size(179, 26);
            this.textBox2.TabIndex = 8;
            this.textBox2.Text = "Linear Gradient Mode";
            this.textBox2.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            // 
            // diagonal
            // 
            this.diagonal.AutoSize = true;
            this.diagonal.Location = new System.Drawing.Point(120, 250);
            this.diagonal.Name = "diagonal";
            this.diagonal.Size = new System.Drawing.Size(97, 24);
            this.diagonal.TabIndex = 9;
            this.diagonal.Text = "Diagonal";
            this.diagonal.UseVisualStyleBackColor = true;
            // 
            // vertical
            // 
            this.vertical.AutoSize = true;
            this.vertical.Location = new System.Drawing.Point(227, 250);
            this.vertical.Name = "vertical";
            this.vertical.Size = new System.Drawing.Size(87, 24);
            this.vertical.TabIndex = 10;
            this.vertical.Text = "Vertical";
            this.vertical.UseVisualStyleBackColor = true;
            // 
            // horizontal
            // 
            this.horizontal.AutoSize = true;
            this.horizontal.Checked = true;
            this.horizontal.Location = new System.Drawing.Point(333, 250);
            this.horizontal.Name = "horizontal";
            this.horizontal.Size = new System.Drawing.Size(106, 24);
            this.horizontal.TabIndex = 11;
            this.horizontal.TabStop = true;
            this.horizontal.Text = "Horizontal";
            this.horizontal.UseVisualStyleBackColor = true;
            // 
            // PickLinearGradient
            // 
            this.AcceptButton = this.ok;
            this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.CancelButton = this.cancel;
            this.ClientSize = new System.Drawing.Size(574, 429);
            this.Controls.Add(this.horizontal);
            this.Controls.Add(this.vertical);
            this.Controls.Add(this.diagonal);
            this.Controls.Add(this.textBox2);
            this.Controls.Add(this.endingColor);
            this.Controls.Add(this.startingColor);
            this.Controls.Add(this.textBox1);
            this.Controls.Add(this.numericUpDown1);
            this.Controls.Add(this.cancel);
            this.Controls.Add(this.ok);
            this.Margin = new System.Windows.Forms.Padding(4, 5, 4, 5);
            this.Name = "PickLinearGradient";
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
        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.TextBox textBox2;
        private System.Windows.Forms.RadioButton diagonal;
        private System.Windows.Forms.RadioButton vertical;
        private System.Windows.Forms.RadioButton horizontal;
    }
}