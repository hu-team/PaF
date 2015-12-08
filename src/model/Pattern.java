package model;

public class Pattern {
    private String context, problem, solution, diagram, consequences;

    public Pattern(String context) {
        this.context = context;
        this.problem = problem;
        this.solution = solution;
        this.diagram = diagram;
        this.consequences = consequences;
    }

    public String getContext() {
        return context;
    }

    public String getSolution() {
        return solution;
    }

    public String getProblem() {
        return problem;
    }

    public String getDiagram() {
        return diagram;
    }

    public String getConsequences() {
        return consequences;
    }

}
