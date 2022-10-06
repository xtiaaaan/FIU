namespace ClassActivity9
{
    public partial class Form1 : Form
    {
        bool drawEllipse = false;
        public Form1()
        {
            InitializeComponent();
            this.SetStyle(ControlStyles.ResizeRedraw, true);
        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.drawEllipse = !this.drawEllipse;
            this.Invalidate(true);
            //this.Refresh();
            //this.Update();
        }

        private void Form1_Paint(object sender, EventArgs e)
        {
            Color fiuGold = Color.FromArgb(182, 134, 44);
            Color fiuBlue = Color.FromArgb(8, 30, 63);
            Brush goldBrush = new SolidBrush(fiuGold);
            Brush blueBrush = new SolidBrush(fiuBlue);
            using(Graphics g = this.CreateGraphics())
            {
                if (drawEllipse)
                    g.FillEllipse(goldBrush, this.ClientRectangle);
                else
                    g.FillEllipse(SystemBrushes.Control, this.ClientRectangle);
            }
        }
    }
}