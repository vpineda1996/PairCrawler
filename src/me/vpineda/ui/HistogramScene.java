package me.vpineda.ui;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import me.vpineda.database.Section;

import java.util.Collection;

/**
 * Created by vpineda1996 on 2015-06-09.
 */
public class HistogramScene {
    final static String PERCENTAGES[] = {"0-9", "10-19", "20-29", "30-39", "40-49",
            "50-54", "55-59", "60-63", "64-67", "68-71", "72-75", "76-79", "80-84",
            "85-89", "90-100"};

    private BarChart<String,Number> bc;
    private static HistogramScene instance = new HistogramScene();

    public static HistogramScene getInstance(){
        return instance;
    }
    private HistogramScene(){}

    public void setupBarChart(final BarChart<String, Number> bc) {
        this.bc = bc;
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        bc.setTitle("Grades Distribution");
        xAxis.setLabel("Percentages");
        yAxis.setLabel("People");
    }
    public void updateGraph(Collection<? extends Section> sections){
        if(bc == null)
            throw new RuntimeException("Initnialize the BarChart first");
        for(Section s : sections){
            XYChart.Series series = new XYChart.Series();
            series.setName(s.getSubject() + " " + s.getCourse() + " " + s.getSection());
            int i = 0;
            for(Integer grade : s.getGrades()){
                series.getData().add(new XYChart.Data<String,Integer>(PERCENTAGES[i++],grade));
            }
            bc.getData().add(series);
        }
    }

    public void clear(){
        bc.getData().clear();
    }
}
