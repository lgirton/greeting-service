import http from 'k6/http';
import { sleep } from 'k6';

const BASEURL = __ENV.BASEURL || "http://localhost:8080";

export const options = {
  vus: 1,
  duration: '10s',

};

export default function () {
  http.get(`${BASEURL}/hello/John`);
};
