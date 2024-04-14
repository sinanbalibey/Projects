import axios from 'axios'

const Base_URL = "http://37.140.242.172:8000/api/"

const getChaosMapAnalysis = async(chaos_map, formData) => {
    const response = await axios.post(Base_URL + chaos_map + "/", {
        formData
    });
    if (response) {
        return response
    }
}

export default getChaosMapAnalysis