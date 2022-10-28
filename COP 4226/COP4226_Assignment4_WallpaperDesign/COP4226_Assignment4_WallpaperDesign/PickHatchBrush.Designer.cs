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
            this.hatchStyleList.ItemHeight = 15;
            this.hatchStyleList.Location = new System.Drawing.Point(25, 23);
            this.hatchStyleList.Margin = new System.Windows.Forms.Padding(4);
            this.hatchStyleList.Name = "hatchStyleList";
            this.hatchStyleList.Size = new System.Drawing.Size(192, 184);
            this.hatchStyleList.TabIndex = 0;
            this.hatchStyleList.SelectedIndexChanged += new System.EventHandler(this.hatchStyleList_SelectedIndexChanged);
            // 
            // foregroundButton
            // 
            this.foregroundButton.Location = new System.Drawing.Point(262, 65);
            this.foregroundButton.Margin = new System.Windows.Forms.Padding(4);
            this.foregroundButton.Name = "foregroundButton";
            this.foregroundButton.Size = new System.Drawing.Size(129, 26);
            this.foregroundButton.TabIndex = 1;
            this.foregroundButton.Text = "Foreground Color";
            this.foregroundButton.UseVisualStyleBackColor = true;
            this.foregroundButton.Click += new System.EventHandler(this.foregroundButton_Click);
            // 
            // backgroundButton
            // 
            this.backgroundButton.Location = new System.Drawing.Point(262, 147);
            this.backgroundButton.Margin = new System.Windows.Forms.Padding(4);
            this.backgroundButton.Name = "backgroundButton";
            this.backgroundButton.Size = new System.Drawing.Size(129, 26);
            this.backgroundButton.TabIndex = 2;
            this.backgroundButton.Text = "Background Color";
            this.backgroundButton.UseVisualStyleBackColor = true;
            this.backgroundButton.Click += new System.EventHandler(this.backgroundButton_Click);
            // 
            // ok
            // 
            this.ok.DialogResult = System.Windows.Forms.DialogResult.OK;
            this.ok.Location = new System.Drawing.Point(66, 281);
            this.ok.Margin = new System.Windows.Forms.Padding(4);
            this.ok.Name = "ok";
            this.ok.Size = new System.Drawing.Size(88, 26);
            this.ok.TabIndex = 5;
            this.ok.Text = "OK";
            this.ok.UseVisualStyleBackColor = true;
            // 
            // cancel
            // 
            this.cancel.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.cancel.Location = new System.Drawing.Point(272, 281);
            this.cancel.Margin = new System.Windows.Forms.Padding(4);
            this.cancel.Name = "cancel";
            this.cancel.Size = new System.Drawing.Size(88, 26);
            this.cancel.TabIndex = 6;
            this.cancel.Text = "Cancel";
            this.cancel.UseVisualStyleBackColor = true;
            // 
            // PickHatchBrush
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(447, 322);
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