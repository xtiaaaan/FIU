using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace COP4226_Assignment2_Minesweeper
{
    public partial class Form3 : Form
    {
        public int row { get; set; }
        public int col { get; set; }
        public int mines { get; set; }
        public Form3()
        {
            InitializeComponent();
        }

        private void okay_Click(object sender, EventArgs e)
        {
<<<<<<< HEAD
            this.Close();
=======
            row = (int)rowUpDown.Value;
            col = (int)colUpDown.Value;
            mines = (int)minesUpDown.Value;
>>>>>>> 0f5131e592f6df9f79e2f26a0d7ab89c691d90db
        }
    }
}
