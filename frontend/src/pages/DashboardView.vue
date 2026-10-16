<script lang="ts" setup>
import { ref, onMounted } from 'vue';
import type { InterviewData } from '../types/InterviewData';
import { getApplications, removeApplication } from "../api/applications";

const applications = ref<InterviewData[]>([]);
const loading = ref(true);
const error = ref(false);


onMounted(async () => {
    try {
        applications.value = await getApplications();

        if (applications.value.length === 0) {
            error.value = true
        }
        loading.value = false;
    } catch (e) {
        console.log("Error getting applications " + e);
        error.value = true;
    }
})

async function handleRowClick(application: InterviewData) {
    if (confirm(`Are you sure you want to remove the application for ${application.companyName}?`)) {
        await removeApplication(application.id)
            .then(() => {
                applications.value = applications.value.filter(app => app.id !== application.id);
            })
            .catch((error) => {
                console.error("Error removing application:", error);
            });
    }
}


</script>

<template>

    <div id="main">
        
        <div id="container">
            
            <table>
                <thead>
                    <tr>
                        <th>Company</th>
                        <th>Status</th>
                        <th>Role</th>
                        <th>Interviewer</th>
                        <th>Interview Date</th>
                    </tr>
                </thead>
                <tbody
                v-if="loading">
                    <tr><td colspan="5">Loading applications...</td></tr>
                </tbody>
                <tbody
                v-if="error">
                    <tr><td colspan="5">!!! Error applications !!!</td></tr>
                </tbody>
                <tbody>
                    <tr 
                    v-for="application in applications" 
                    :key="application.id"
                    @click="handleRowClick(application)"
                    >
                        <td>{{ application.companyName }}</td>
                        <td :class="application.status">{{ application.status }}</td>
                        <td>{{ application.role }}</td>
                        <td>{{ application.interviewer }}</td>
                        <td>{{ application.interviewDate }}</td>
                    </tr>
                </tbody>
            </table>

        </div>

    </div>

</template>

<style scoped>

#container {
    display: flex;
    justify-content: center;
    align-items: center;
}

table, th, td {
    color: white;
    padding: 1rem;
    font-size: 1.5rem;
}

th {
    border-bottom: 0.1rem solid white;
    background-color: rgba(209, 204, 204, 0.288);
}

td {
    border-left: 0.1rem solid white;
    border-right: 0.1rem solid white;
    text-align: center;
}

table {
    border-collapse: collapse;
    border: 0.1rem solid white;
    border-radius: 0.5rem;
}

td.Pending {
    background-color: rgba(244, 244, 70, 0.239);
    box-shadow: 0.1rem 0.1rem 1rem rgba(244, 244, 70, 0.239);
}

td.Active {
    background-color: rgba(70, 244, 96, 0.239);
    box-shadow: 0.1rem 0.1rem 1rem rgba(70, 244, 96, 0.239);
}

td.Rejected {
    background-color: rgba(244, 70, 70, 0.239);
    box-shadow: 0.1rem 0.1rem 1rem rgba(244, 70, 70, 0.239);
}

td.Unknown {
    background-color: rgba(245, 146, 8, 0.239);
    box-shadow: 0.1rem 0.1rem 1rem rgba(245, 146, 8, 0.239);
}

tr {
    background-color: rgba(44, 44, 44, 0.577);
}

tr:hover {
    cursor: pointer;
    border: 0.1rem solid white;
    box-shadow: 0.1rem 0.1rem 1rem white;
    transition: box-shadow 0.25s;
}

</style>