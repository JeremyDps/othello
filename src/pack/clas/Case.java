package pack.clas;

public class Case {
	String valeur_Case;
	int x,y;
	//boolean isVide=true;
	Pion p;

	public Case(String valeur_Case, int x, int y) {
		super();
		this.valeur_Case = valeur_Case;
		this.x = x;
		this.y = y;
		this.p=null;
	}

	Case placer_un_pion(Pion pion)
	{
		if(p== null)
		{
			this.valeur_Case=pion.valeur_pion;
			p=pion;
		} return this;
		
	}

	String  changer_valeur_case(Pion p,Case c)
	{
		c.valeur_Case=p.valeur_pion;
		return c.valeur_Case;
	}

	@Override
	public String toString() {
		return "Case [valeur_Case=" + valeur_Case + ", x=" + x + ", y=" + y + ",p=" + p +  "]";
	}
	public String getValeur_Case() {
		return valeur_Case;
	}
	public void setValeur_Case(String valeur_Case) {
		this.valeur_Case = valeur_Case;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Pion getP() {
		return p;
	}
	public void setP(Pion p) {
		this.p = p;
	}
	
}
