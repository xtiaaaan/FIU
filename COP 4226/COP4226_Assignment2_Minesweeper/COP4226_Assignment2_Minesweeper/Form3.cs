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
            int value;
            if(!int.TryParse(rowBox.Text, out value) || !int.TryParse(columnBox.Text, out value) || !int.TryParse(minesBox.Text, out value))
            {
                MessageBox.Show("Please enter a valid integer", "Invalid Input", MessageBoxButtons.OK);
            }
            else if(int.Parse(rowBox.Text) <= 0 || int.Parse(columnBox.Text) <= 0 || int.Parse(minesBox.Text) <= 0)
            {
                MessageBox.Show("Please enter an integer greater than 0", "No zeroes and negative numbers", MessageBoxButtons.OK);
            }
            else
            {
                row = int.Parse(rowBox.Text);
                col = int.Parse(columnBox.Text);
                mines = int.Parse(minesBox.Text);
                this.DialogResult = System.Windows.Forms.DialogResult.OK;
            }
            this.Close();
        }
    }
}
