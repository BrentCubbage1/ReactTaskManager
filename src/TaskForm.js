import React, { useState } from "react";

/* This syntax defines a functional component using an arrow function.
() => { .. is an anonymous arrow function with no parameters.
    Kind of similar to defining a functional interface in Java with a lambda but different.
    */

const TaskForm = () => {

    /*this is a "useState Hook"
    useStates return two values, the current state and a function that updates the state
    taskname will be the state, setTaskName will be the function that sets the state.
    it's initialized under as an empty state. Same with taskDescription */

    const [taskName, setTaskName] = useState('');
    const [taskDescription, setTaskDescription] = useState('');


    /* handleNameChange is a function that takes a parameter of an "event" which is an event triggered by a user
    the 'event' will end up being the user putting in the task name into the input box.
    event.target is the DOM element that figured
    .value is the value currently in the target.
     */
    const handleNameChange = (event) => {
        setTaskName(event.target.value);
    };

    /* same thing applies from handleNameChange */

    const handleDescriptionChange = (event) => {
        setDescriptionName(event.target.value);
    };

    /* preventDefault stops the default action a browser does when you submit to a page.
    That is typically reloading the page/navigating to a new page.
    With React, usually handle the task submission without reloading the full page. */
    const handleSubmit = (event) => {
        event.preventDefault();
        console.log('Task name:', taskName);
        console.log('Task Description:', taskDescription);

        //will handle the logic of submissions here later. 
    };


    /* this is JSX which allows you to write HTML-like code in your JS
    JSX (JavaScript XML) defines what the Component will render when exported
    Makes it easier to define and structure your UI */
    return (
        <div>
            <h2>Create a New Task</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label htmlFor="taskName">Task Name:</label>
                    <input
                    type="text"
                    id="taskName"
                    value={taskName}
                    onChange={handleNameChange}
                    />
                </div>
                <div>
                    <label htmlFor="taskDescription">Task Description:</label>
                    <textarea
                    id="taskDescription"
                    value={taskDescription}
                    onChange={handleDescriptionChange}
                    />
                </div>
                <button type="submit">Create Task</button>
            </form>
        </div>
    );
};

export default TaskForm;