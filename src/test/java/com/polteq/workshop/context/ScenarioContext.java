package com.polteq.workshop.context;

import com.polteq.workshop.pages.QuizPage;

import java.util.List;

/**
 * A class that holds shared data and states for a testing scenario,
 * providing context for step definitions and scenario setup/teardown processes.
 */
public class ScenarioContext {
    public List<String> countries;
    public QuizPage quizPage;
}
