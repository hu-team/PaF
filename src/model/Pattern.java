package model;

public class Pattern {
    private String context, problem, solution, diagram, consequences, name;

    public Pattern(String context, String problem, String solution, String consequences,String diagram, String name) {
        this.context = context;
        this.problem = problem;
        this.solution = solution;
        this.diagram = diagram;
        this.consequences = consequences;
        this.name = name;
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

    public String getName() {
        return name;
    }

}
