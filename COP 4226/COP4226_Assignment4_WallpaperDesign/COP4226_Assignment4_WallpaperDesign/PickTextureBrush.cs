using System;
using System.CodeDom;
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
    public partial class PickTextureBrush : Form
    {
        public System.Drawing.Drawing2D.WrapMode wrapmode;
        public string filepath = "";
        public PickTextureBrush()
        {
            InitializeComponent();
        }

        private void uploadFile_Click(object sender, EventArgs e)
        {
            string fileDirectory = Environment.GetFolderPath(Environment.SpecialFolder.MyPictures);

            openFileDialog1.InitialDirectory = fileDirectory;
            openFileDialog1.RestoreDirectory = true;
            openFileDialog1.Filter = "All Files (*.*)|*.*";
            openFileDialog1.FilterIndex = 1;

            if (openFileDialog1.ShowDialog() == DialogResult.OK)
                if (openFileDialog1.FileName != "")
                    filepath = openFileDialog1.FileName;
        }

        private void ok_Click(object sender, EventArgs e)
        {
            if (tileRadioButton.Checked)
                wrapmode = System.Drawing.Drawing2D.WrapMode.Tile;
            else if (flipXRadioButton.Checked)
                wrapmode = System.Drawing.Drawing2D.WrapMode.TileFlipX;
            else if (flipYRadioButton.Checked)
                wrapmode = System.Drawing.Drawing2D.WrapMode.TileFlipY;
            else if (filpXYRadioButton.Checked)
                wrapmode = System.Drawing.Drawing2D.WrapMode.TileFlipXY;
            else if (clampButton.Checked)
                wrapmode = System.Drawing.Drawing2D.WrapMode.Clamp;
            
            if(openFileDialog1.FileName == "")
            {
                MessageBox.Show("No file found. Please try again!");
                DialogResult = DialogResult.None;
            }
            else
            {
                DialogResult = DialogResult.OK;
                this.Close();
            }
        }

        private void cancel_Click(object sender, EventArgs e)
        {
            DialogResult = DialogResult.Cancel;
            this.Close();
        }
    }
}
