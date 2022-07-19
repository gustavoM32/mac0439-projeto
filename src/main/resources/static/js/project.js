function confirmSubmit(msg) {
    return confirm(msg)
}

function deleteItem(url, confirmationMessage, redirectUrl) {
    if (!confirm(confirmationMessage)) return;

    fetch(url, { method: 'DELETE' })
        .then((res) => {
            console.info(res)
            window.location.pathname = redirectUrl
        })
        .catch((e) => {
            console.error(e)
        })
}

function deleteTask(data) {
    //console.info(data);

    deleteItem(
        `/projects/${data.pid}/tasks/${data.id}`,
        "Você tem certeza que deseja remover esta tarefa?",
        `/tasks`
    );

}

function deleteProject(data) {
    //console.info(data);

    deleteItem(
        `/projects/${data.id}`,
        "Você tem certeza que deseja remover projeto?",
        `/projects`
    );

}

//
//$(document).ready(function() {
//    $(".replace-nl").each(function() {
//        let oldText = $( this ).html()
//        let newText = replaceNewLineWithBR(oldText)
//        $( this ).html(newText)
//    })
//});
