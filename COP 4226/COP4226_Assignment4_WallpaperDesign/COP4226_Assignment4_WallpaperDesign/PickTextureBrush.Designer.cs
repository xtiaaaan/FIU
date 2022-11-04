namespace COP4226_Assignment4_WallpaperDesign
{
    partial class PickTextureBrush
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
            this.tileRadioButton = new System.Windows.Forms.RadioButton();
            this.flipXRadioButton = new System.Windows.Forms.RadioButton();
            this.flipYRadioButton = new System.Windows.Forms.RadioButton();
            this.filpXYRadioButton = new System.Windows.Forms.RadioButton();
            this.clampButton = new System.Windows.Forms.RadioButton();
            this.openFileDialog1 = new System.Windows.Forms.OpenFileDialog();
            this.uploadButton = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.ok = new System.Windows.Forms.Button();
            this.cancel = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // tileRadioButton
            // 
            this.tileRadioButton.AutoSize = true;
            this.tileRadioButton.Location = new System.Drawing.Point(44, 107);
            this.tileRadioButton.Margin = new System.Windows.Forms.Padding(4, 3, 4, 3);
            this.tileRadioButton.Name = "tileRadioButton";
            this.tileRadioButton.Size = new System.Drawing.Size(43, 19);
            this.tileRadioButton.TabIndex = 0;
            this.tileRadioButton.TabStop = true;
            this.tileRadioButton.Text = "Tile";
            this.tileRadioButton.UseVisualStyleBackColor = true;
            // 
            // flipXRadioButton
            // 
            this.flipXRadioButton.AutoSize = true;
            this.flipXRadioButton.Location = new System.Drawing.Point(177, 107);
            this.flipXRadioButton.Margin = new System.Windows.Forms.Padding(4, 3, 4, 3);
            this.flipXRadioButton.Name = "flipXRadioButton";
            this.flipXRadioButton.Size = new System.Drawing.Size(69, 19);
            this.flipXRadioButton.TabIndex = 1;
            this.flipXRadioButton.TabStop = true;
            this.flipXRadioButton.Text = "TileFlipX";
            this.flipXRadioButton.UseVisualStyleBackColor = true;
            // 
            // flipYRadioButton
            // 
            this.flipYRadioButton.AutoSize = true;
            this.flipYRadioButton.Location = new System.Drawing.Point(44, 150);
            this.flipYRadioButton.Margin = new System.Windows.Forms.Padding(4, 3, 4, 3);
            this.flipYRadioButton.Name = "flipYRadioButton";
            this.flipYRadioButton.Size = new System.Drawing.Size(69, 19);
            this.flipYRadioButton.TabIndex = 2;
            this.flipYRadioButton.TabStop = true;
            this.flipYRadioButton.Text = "TileFlipY";
            this.flipYRadioButton.UseVisualStyleBackColor = true;
            // 
            // filpXYRadioButton
            // 
            this.filpXYRadioButton.AutoSize = true;
            this.filpXYRadioButton.Location = new System.Drawing.Point(177, 150);
            this.filpXYRadioButton.Margin = new System.Windows.Forms.Padding(4, 3, 4, 3);
            this.filpXYRadioButton.Name = "filpXYRadioButton";
            this.filpXYRadioButton.Size = new System.Drawing.Size(76, 19);
            this.filpXYRadioButton.TabIndex = 3;
            this.filpXYRadioButton.TabStop = true;
            this.filpXYRadioButton.Text = "TileFlipXY";
            this.filpXYRadioButton.UseVisualStyleBackColor = true;
            // 
            // clampButton
            // 
            this.clampButton.AutoSize = true;
            this.clampButton.Location = new System.Drawing.Point(44, 192);
            this.clampButton.Margin = new System.Windows.Forms.Padding(4, 3, 4, 3);
            this.clampButton.Name = "clampButton";
            this.clampButton.Size = new System.Drawing.Size(60, 19);
            this.clampButton.TabIndex = 4;
            this.clampButton.TabStop = true;
            this.clampButton.Text = "Clamp";
            this.clampButton.UseVisualStyleBackColor = true;
            // 
            // openFileDialog1
            // 
            this.openFileDialog1.FileName = "openFileDialog1";
            // 
            // uploadButton
            // 
            this.uploadButton.Location = new System.Drawing.Point(177, 192);
            this.uploadButton.Margin = new System.Windows.Forms.Padding(4, 3, 4, 3);
            this.uploadButton.Name = "uploadButton";
            this.uploadButton.Size = new System.Drawing.Size(99, 27);
            this.uploadButton.TabIndex = 5;
            this.uploadButton.Text = "Upload Image";
            this.uploadButton.UseVisualStyleBackColor = true;
            this.uploadButton.Click += new System.EventHandler(this.uploadFile_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point);
            this.label1.Location = new System.Drawing.Point(85, 65);
            this.label1.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(100, 20);
            this.label1.TabIndex = 6;
            this.label1.Text = "Wrap Mode";
            // 
            // ok
            // 
            this.ok.Location = new System.Drawing.Point(44, 269);
            this.ok.Margin = new System.Windows.Forms.Padding(4, 3, 4, 3);
            this.ok.Name = "ok";
            this.ok.Size = new System.Drawing.Size(88, 27);
            this.ok.TabIndex = 7;
            this.ok.Text = "Ok";
            this.ok.UseVisualStyleBackColor = true;
            this.ok.Click += new System.EventHandler(this.ok_Click);
            // 
            // cancel
            // 
            this.cancel.Location = new System.Drawing.Point(177, 269);
            this.cancel.Margin = new System.Windows.Forms.Padding(4, 3, 4, 3);
            this.cancel.Name = "cancel";
            this.cancel.Size = new System.Drawing.Size(88, 27);
            this.cancel.TabIndex = 8;
            this.cancel.Text = "Cancel";
            this.cancel.UseVisualStyleBackColor = true;
            this.cancel.Click += new System.EventHandler(this.cancel_Click);
            // 
            // PickTextureBrush
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(308, 340);
            this.Controls.Add(this.cancel);
            this.Controls.Add(this.ok);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.uploadButton);
            this.Controls.Add(this.clampButton);
            this.Controls.Add(this.filpXYRadioButton);
            this.Controls.Add(this.flipYRadioButton);
            this.Controls.Add(this.flipXRadioButton);
            this.Controls.Add(this.tileRadioButton);
            this.Margin = new System.Windows.Forms.Padding(4, 3, 4, 3);
            this.Name = "PickTextureBrush";
            this.Text = "PickTextureBrush";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.RadioButton tileRadioButton;
        private System.Windows.Forms.RadioButton flipXRadioButton;
        private System.Windows.Forms.RadioButton flipYRadioButton;
        private System.Windows.Forms.RadioButton filpXYRadioButton;
        private System.Windows.Forms.RadioButton clampButton;
        private System.Windows.Forms.OpenFileDialog openFileDialog1;
        private System.Windows.Forms.Button uploadButton;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button ok;
        private System.Windows.Forms.Button cancel;
    }
}