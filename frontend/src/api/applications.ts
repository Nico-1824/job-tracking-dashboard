async function getApplications() {
    let response = await fetch("/api/v1/get_applications");

    let retry = 0;
    while (!response.ok && retry < 3) {
        response = await fetch("/api/v1/get_applications");
        retry++;
    }

    if (!response.ok) {
        return [];
    }

    const data = await response.json();
    if (data[0]["companyName"] === "Error") { 
        return [];
    }

    return data;

}

async function removeApplication(id: number) {
    const response = await fetch(`/api/v1/remove_application?id=${id}`, {
        method: "DELETE",
    });

    if (!response.ok) {
        return false;
    }

    return true;
}

export { getApplications, removeApplication };