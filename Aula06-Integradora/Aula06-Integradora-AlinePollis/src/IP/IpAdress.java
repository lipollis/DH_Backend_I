package IP;

public class IpAdress {
    // ATRIBUTOS DO OBJETO - IP ADRESS: aaa.bbb.ccc.ddd
    private int ip_aaa;
    private int ip_bbb;
    private int ip_ccc;
    private int ip_ddd;

    // CONSTRUTOR DO OBJETO

    public IpAdress(int ip_aaa, int ip_bbb, int ip_ccc, int ip_ddd) {
        this.ip_aaa = ip_aaa;
        this.ip_bbb = ip_bbb;
        this.ip_ccc = ip_ccc;
        this.ip_ddd = ip_ddd;
    }

    // GETTER & SETTER
    public int getIp_aaa() {
        return ip_aaa;
    }

    public void setIp_aaa(int ip_aaa) {
        this.ip_aaa = ip_aaa;
    }

    public int getIp_bbb() {
        return ip_bbb;
    }

    public void setIp_bbb(int ip_bbb) {
        this.ip_bbb = ip_bbb;
    }

    public int getIp_ccc() {
        return ip_ccc;
    }

    public void setIp_ccc(int ip_ccc) {
        this.ip_ccc = ip_ccc;
    }

    public int getIp_ddd() {
        return ip_ddd;
    }

    public void setIp_ddd(int ip_ddd) {
        this.ip_ddd = ip_ddd;
    }

    // toString
    @Override
    public String toString() {
        return "IpAdress{"
                + ip_aaa + "."
                + ip_bbb + "."
                + ip_ccc + "."
                + ip_ddd +
                '}';
    }
}
