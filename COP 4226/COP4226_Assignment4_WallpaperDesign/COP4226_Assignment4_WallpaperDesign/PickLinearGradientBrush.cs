using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace COP4226_Assignment4_WallpaperDesign
{
    public partial class PickLinearGradientBrush : Form
    {
        public Color beginningColor, lastColor;
        public int size, angle;
        public PickLinearGradientBrush()
        {
            InitializeComponent();
            beginningColor = new Color();
            lastColor = new Color();
            NumericUpDown numericUpDown1 = this.numericUpDown1;
            size = (int)numericUpDown1.Value;
            angle = 0;
        }

        private void startingColor_Click(object sender, EventArgs e)
        {
            DialogResult d = colorDialog1.ShowDialog();
            if (d == DialogResult.OK)
                beginningColor = colorDialog1.Color;
            startingColor.BackColor = colorDialog1.Color;
        }
        private void endingColor_Click(object sender, EventArgs e)
        {
            DialogResult d = colorDialog2.ShowDialog();
            if (d == DialogResult.OK)
                lastColor = colorDialog1.Color;
            endingColor.BackColor = colorDialog2.Color;
        }
        

        private void numericUpDown1_ValueChanged(object sender, EventArgs e)
        {
            size = (int)numericUpDown1.Value;
        }

        private void horizontal_Checked(object sender, EventArgs e)
        {
            angle = 180;
        }

        private void vertical_Checked(object sender, EventArgs e)
        {
            angle = 90;
        }

        private void diagonal_Checked(object sender, EventArgs e)
        {
            angle = 45;
        }
    }
}
