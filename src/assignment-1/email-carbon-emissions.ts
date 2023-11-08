import { carbonEmissionsCalculator } from "./carbon-emissions-calculator";
import { question } from "readline-sync";
import { Entity } from "./types";

const entityType: string = question('Enter entity type (email/server): ');
const email: string = question('Enter email ID: ');
const provider: string = question('Enter email provider (gmail/outlook/yahoo): ');
const inbox = parseFloat(question('Enter inbox emails: '));
const sent = parseFloat(question('Enter sent emails: '));
const spam = parseFloat(question('Enter spam emails: '));

const entity: Entity = { email, provider, inbox, sent, spam };
const result = carbonEmissionsCalculator.getEmissions(entityType, entity);
console.log(`Carbon Footprint: ${result}g`);
