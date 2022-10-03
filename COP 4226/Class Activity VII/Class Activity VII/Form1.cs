using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Class_Activity_VII
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void increaseCountToolStripMenuItem_Click(object sender, EventArgs e)
        {
            numericUpDown1.Value++;
        }

        private void numericUpDown1_ValueChanged(object sender, EventArgs e)
        {
            if(numericUpDown1.ContainsFocus)
            {
                decimal count = numericUpDown1.Value;
                if (count > 0)
                    toDate.Value = fromDate.Value.AddDays((double)count);
                else if (count < 0)
                    fromDate.Value = toDate.Value.AddDays((double)-count);
                else
                    toDate.Value = fromDate.Value;
            }
        }

        private void fromDate_ValueChanged(object sender, EventArgs e)
        {
            if (((DateTimePicker)sender).ContainsFocus)
            {
                DateTime to = toDate.Value;
                DateTime from = fromDate.Value;
                numericUpDown1.Value = to.Subtract(from).Days;
                numericUpDown1.Value = numericUpDown1.Value + (decimal)1;
            }
        }
    }
}
