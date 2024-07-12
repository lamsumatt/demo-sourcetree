const taskInput = document.getElementById("taskInput");
const taskList = document.getElementById("taskList");

//Function
function addTask() {
  const taskText = taskInput.value.trim();
  if (taskText === "") {
    alert("You Need To Write Something!!");
  } else {
    addToList(taskText);
    taskInput.value = "";
    console.log("taskText", taskText);
    saveData(taskText);
    sortTask();
  }
}

function sortTask() {
  const li = document.createElement("li");
  // const tasks = [...Array.from(taskList.getElementsByTagName("p"))].map(
  //   (item) => item
  // );
  // const tasks = [...JSON.parse(JSON.stringify(localStorage.getItem("tasks")))];
  const tasks = JSON.parse(localStorage.getItem("tasks")) || [];
  // tasks.push(addtask);
  taskList.innerHTML = "";
  return tasks.sort().forEach((_item) => {
    const li = document.createElement("li");
    li.innerHTML =
      `<p class="task">${_item}</p>` +
      ` <span class="delete" data-attr=${_item} onclick="Delete(this)">Delete</span> 
            <span class="edit" onclick="Edit(this)">Edit</span>`;
    taskList.appendChild(li);
  });

  // return tasks.sort((a, b) => a - b);
}

function addToList(addtask) {
  // const li = document.createElement("li");
  // li.innerHTML =
  //   `<p>${addtask}</p>` +
  //   ' <span class="delete" onclick="Delete(this)">Delete</span> <span class="edit" onclick="Edit(this)">Edit</span>';
  // taskList.appendChild(li);
  //sort();
  sortTask(addtask);
}

function Delete(task) {
  const value = task.getAttribute("data-attr");
  const tasks = JSON.parse(localStorage.getItem("tasks")) || [];
  const findIndex = tasks.findIndex((item) => item == value);

  task.parentElement.remove();
  tasks.splice(findIndex, 1);
  localStorage.setItem("tasks", JSON.stringify(tasks));
}

function Edit(task) {
  const editTask = task.parentElement.firstChild;
  const editTaskText = editTask.textContent.trim();
  const newTaskText = prompt("Edit task:", editTaskText);
  sortTask();
  0;
}
/// Filter Option
function filterOption() {}

function saveData(data) {
  const tasks = JSON.parse(localStorage.getItem("tasks")) || [];

  if (data) {
    tasks.push(data);
  }
  localStorage.setItem("tasks", JSON.stringify(tasks));
}

//EnventListener

document.addEventListener("DOMContentLoaded", function () {
  {
    const task = JSON.parse(localStorage.getItem("tasks")) || [];
    console.log("addEventListener - task", task);
    sortTask();
  }
});

taskList.addEventListener(
  "click",
  function (e) {
    if (e.target.tagName === "LI") {
      e.target.classList.toggle("checked");
    } else if (e.target.tagName === "SPAN") {
      e.target.parentElement.remove();
    }
  },
  false
);
