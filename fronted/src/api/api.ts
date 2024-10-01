import axios from "axios";

export const api = axios.create({
  baseURL: "http://localhost:8080/",
  timeout: 50000,
  headers: {
    "Content-Type": "application/json",
  },
});
