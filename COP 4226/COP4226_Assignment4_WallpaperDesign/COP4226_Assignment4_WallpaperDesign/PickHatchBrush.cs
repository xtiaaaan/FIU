using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Drawing.Drawing2D;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace COP4226_Assignment4_WallpaperDesign
{
    public partial class PickHatchBrush : Form
    {
        public PickHatchBrush()
        {
            InitializeComponent();
            foregroundColor = SystemColors.ButtonFace;
        }

        private void foregroundButton_Click(object sender, EventArgs e)
        {
            DialogResult d = colorDialog1.ShowDialog();
            if (d == DialogResult.OK)
                foregroundColor = colorDialog1.Color;
            foregroundColor = Color.FromArgb(foregroundColor.R,foregroundColor.G,foregroundColor.B);
            foregroundButton.BackColor = foregroundColor;
        }

        private void backgroundButton_Click(object sender, EventArgs e)
        {
            DialogResult d = colorDialog2.ShowDialog();
            if (d == DialogResult.OK)
                backgroundColor = colorDialog2.Color;
            backgroundColor = Color.FromArgb(backgroundColor.R,backgroundColor.G,backgroundColor.B);
            backgroundButton.BackColor = backgroundColor;
        }

        private void hatchStyleList_SelectedIndexChanged(object sender, EventArgs e)
        {
            hatchStyleText = hatchStyleList.GetItemText(hatchStyleList.SelectedIndex);
            hs = (HatchStyle)Enum.Parse(typeof(HatchStyle), hatchStyleText, true);
        }
    }
}
