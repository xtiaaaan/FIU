using System.Drawing;
using System.Drawing.Drawing2D;

namespace COP4226_Assignment4_WallpaperDesign
{
    partial class PickHatchBrush
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
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.hatchStyleList = new System.Windows.Forms.ListBox();
            this.foregroundButton = new System.Windows.Forms.Button();
            this.backgroundButton = new System.Windows.Forms.Button();
            this.colorDialog1 = new System.Windows.Forms.ColorDialog();
            this.colorDialog2 = new System.Windows.Forms.ColorDialog();
            this.ok = new System.Windows.Forms.Button();
            this.cancel = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // hatchStyleList
            // 
            this.hatchStyleList.FormattingEnabled = true;
            this.hatchStyleList.ItemHeight = 16;
            this.hatchStyleList.Location = new System.Drawing.Point(29, 25);
            this.hatchStyleList.Margin = new System.Windows.Forms.Padding(4);
            this.hatchStyleList.Name = "hatchStyleList";
            this.hatchStyleList.Size = new System.Drawing.Size(219, 196);
            this.hatchStyleList.TabIndex = 0;
            // 
            // foregroundButton
            // 
            this.foregroundButton.Location = new System.Drawing.Point(299, 69);
            this.foregroundButton.Margin = new System.Windows.Forms.Padding(4);
            this.foregroundButton.Name = "foregroundButton";
            this.foregroundButton.Size = new System.Drawing.Size(147, 28);
            this.foregroundButton.TabIndex = 1;
            this.foregroundButton.Text = "Foreground Color";
            this.foregroundButton.UseVisualStyleBackColor = true;
            // 
            // backgroundButton
            // 
            this.backgroundButton.Location = new System.Drawing.Point(299, 157);
            this.backgroundButton.Margin = new System.Windows.Forms.Padding(4);
            this.backgroundButton.Name = "backgroundButton";
            this.backgroundButton.Size = new System.Drawing.Size(147, 28);
            this.backgroundButton.TabIndex = 2;
            this.backgroundButton.Text = "Background Color";
            this.backgroundButton.UseVisualStyleBackColor = true;
            // 
            // ok
            // 
            this.ok.DialogResult = System.Windows.Forms.DialogResult.OK;
            this.ok.Location = new System.Drawing.Point(76, 300);
            this.ok.Margin = new System.Windows.Forms.Padding(4);
            this.ok.Name = "ok";
            this.ok.Size = new System.Drawing.Size(100, 28);
            this.ok.TabIndex = 5;
            this.ok.Text = "OK";
            this.ok.UseVisualStyleBackColor = true;
            // 
            // cancel
            // 
            this.cancel.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.cancel.Location = new System.Drawing.Point(311, 300);
            this.cancel.Margin = new System.Windows.Forms.Padding(4);
            this.cancel.Name = "cancel";
            this.cancel.Size = new System.Drawing.Size(100, 28);
            this.cancel.TabIndex = 6;
            this.cancel.Text = "Cancel";
            this.cancel.UseVisualStyleBackColor = true;
            // 
            // PickHatchBrush
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(511, 343);
            this.Controls.Add(this.cancel);
            this.Controls.Add(this.ok);
            this.Controls.Add(this.backgroundButton);
            this.Controls.Add(this.foregroundButton);
            this.Controls.Add(this.hatchStyleList);
            this.Margin = new System.Windows.Forms.Padding(4);
            this.Name = "PickHatchBrush";
            this.Text = "PickHatchBrush";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.ListBox hatchStyleList;
        private System.Windows.Forms.Button foregroundButton;
        private System.Windows.Forms.Button backgroundButton;
        private System.Windows.Forms.Button ok;
        private System.Windows.Forms.Button cancel;
        private System.Windows.Forms.ColorDialog colorDialog1;
        private System.Windows.Forms.ColorDialog colorDialog2;
        internal Color foregroundColor;
        internal Color backgroundColor;
        internal string hatchStyleText;
        internal HatchStyle hs;
    }
}