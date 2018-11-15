public abstract class ReportController
{
    final void processReport()
    {
        loadData();
        formatData();
        displayData();
    }

    abstract void loadData();
    abstract String formatData();

    public String displayData()
    {
        return "";
    }
}

class FeeReport extends ReportController
{
    public void loadData()
    {   }

    public String formatData()
    {
        return "error?";
    }
}

class CheckoutReport extends ReportController
{
    public void loadData()
    {   }

    public String formatData()
    {
        return "a different string";
    }
}