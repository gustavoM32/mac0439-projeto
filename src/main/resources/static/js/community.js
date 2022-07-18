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

function deleteCommunity(data) {
    deleteItem(
        `/communities/${data.cid}`,
        "Você tem certeza que deseja remover comunidade?",
        `/communities`
    )
}

function deletePublication(data) {
    deleteItem(
        `/communities/${data.cid}/publications/${data.pid}`,
        "Você tem certeza que deseja remover publicação?",
        `/communities/${data.cid}`
    )
}

function deleteComment(data) {
    deleteItem(
        `/communities/${data.cid}/publications/${data.pid}/comments/${data.cmid}`,
        "Você tem certeza que deseja remover comentário?",
        `/communities/${data.cid}`
    )
}

function deleteEvent(data) {
	deleteItem(
		`/communities/${data.cid}/events/${data.eid}`,
		"Você tem certeza que deseja remover evento?",
		`/communities/${data.cid}/events`
	)
}

function replaceNewLineWithBR(text) {
    return text.replaceAll("\n", "<br>")
}

$(document).ready(function() {
    $(".replace-nl").each(function() {
        let oldText = $( this ).html()
        let newText = replaceNewLineWithBR(oldText)
        $( this ).html(newText)
    })
});
