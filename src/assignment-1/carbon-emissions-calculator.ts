import { Entity, EntityHandlers, ProviderEmissions } from "./types";
import { readFileSync } from 'fs'

class CarbonEmissionsCalculator {
    private providerEmissions: ProviderEmissions = {};
    private entityHandlers: EntityHandlers = {};

    constructor() {
        this.loadProviderEmissions();
        this.initializeEntityHandlers();
    }

    private initializeEntityHandlers(): void {
        this.entityHandlers = {
            email: this.calculateEmailEmissions.bind(this),
            server: this.calculateServerEmissions.bind(this),
        };
    }

    private loadProviderEmissions(): void {
        const providerCarbonEmissions = readFileSync('src/assignment-1/provider-carbon-emissions.json', 'utf8');
        this.providerEmissions = JSON.parse(providerCarbonEmissions);
    }

    private calculateEmailEmissions(email: Entity): string {
        const { provider = '', inbox = 0, sent = 0, spam = 0 } = email;
        const providerEmission = this.providerEmissions[provider.toLowerCase()];

        if (providerEmission) {
            const { inbox: providerInboxEmission, sent: providerSentEmission, spam: providerSpamEmission } = providerEmission;
            return (inbox * providerInboxEmission + sent * providerSentEmission + spam * providerSpamEmission).toString();
        } else {
            return `Unknown email provider: ${provider}`;
        }
    }

    private calculateServerEmissions(entity: Entity): string {
        return 'No implementation for server footprint calculation';
    }

    getEmissions(entityType: string, entity: Entity): string {
        const handler = this.entityHandlers[entityType];
        return handler ? handler(entity) : 'Invalid entity type';
    }
}

const carbonEmissionsCalculator = new CarbonEmissionsCalculator();
export { carbonEmissionsCalculator };
